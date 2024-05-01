package com.sushi.tuyenbeoo.authentication.service.domain.component;

import com.sushi.tuyenbeoo.authentication.service.infrastructure.repository.TokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

import static com.sushi.tuyenbeoo.authentication.service.domain.constant.HeaderConstant.BEAR;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    private final UserDetailsService userDetailsService;

    private final TokenRepository tokenRepository;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (Objects.isNull(authHeader) || !authHeader.startsWith(BEAR)) {
            filterChain.doFilter(request, response);
            return;
        }

        final String jwt = authHeader.substring(BEAR.length() + 1);
        final String loginId = tokenService.extractUsername(jwt);
        if (Objects.isNull(loginId) || Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {
            filterChain.doFilter(request, response);
            return;
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(loginId);

        boolean isTokenValid = tokenRepository.findByToken(jwt)
                .map(t -> !t.isExpired() && !t.isRevoked())
                .orElse(false);

        if (!isTokenValid || !tokenService.isTokenValid(jwt, userDetails)) {
            filterChain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request, response);
    }
}
