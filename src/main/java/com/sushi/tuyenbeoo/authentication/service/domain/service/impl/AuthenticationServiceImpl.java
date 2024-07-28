package com.sushi.tuyenbeoo.authentication.service.domain.service.impl;

import com.sushi.tuyenbeoo.authentication.service.domain.component.TokenService;
import com.sushi.tuyenbeoo.authentication.service.domain.data.UserData;
import com.sushi.tuyenbeoo.authentication.service.domain.dto.UserDTO;
import com.sushi.tuyenbeoo.authentication.service.domain.dto.request.AuthenticationRequest;
import com.sushi.tuyenbeoo.authentication.service.domain.dto.request.RegisterRequest;
import com.sushi.tuyenbeoo.authentication.service.domain.dto.response.AuthenticationResponse;
import com.sushi.tuyenbeoo.authentication.service.domain.entity.User;
import com.sushi.tuyenbeoo.authentication.service.domain.enumf.StatusEnum;
import com.sushi.tuyenbeoo.authentication.service.domain.mapper.EntityMapper;
import com.sushi.tuyenbeoo.authentication.service.domain.service.user.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final TokenService tokenService;

    @Autowired
    private UserData userData;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        UserDTO userDTO = UserDTO.builder()
                .loginId(request.getLoginId())
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNo(request.getPhoneNo())
                .gender(request.getGender())
                .status(StatusEnum.ACTIVE)
                .login(StatusEnum.INACTIVE)
                .role(request.getRole())
                .build();
        User user = userData.saveUser(EntityMapper.INSTANCE.userDtoToUser(userDTO));

        UserDetails userDetails = getUserDetailsFromUser(user);
        String jwt = tokenService.generateToken(userDetails);
        String refreshToken = tokenService.generateRefreshToken(userDetails);
        return null;
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        return null;
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {

    }

    private UserDetails getUserDetailsFromUser(User user) {
        final List<GrantedAuthority> authorities = new ArrayList<>(user.getRole().getAuthorities());
        return new org.springframework.security.core.userdetails.User(user.getLoginId(), user.getPassword(), authorities);
    }
}
