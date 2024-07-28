package com.sushi.tuyenbeoo.authentication.service.infrastructure.data;

import com.sushi.tuyenbeoo.authentication.service.domain.entity.User;
import com.sushi.tuyenbeoo.authentication.service.domain.enumf.ErrorEnum;
import com.sushi.tuyenbeoo.authentication.service.domain.exception.GenericException;
import com.sushi.tuyenbeoo.authentication.service.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLoginId(username).orElseThrow(() -> new GenericException(ErrorEnum.USER_NAME_NOT_FOUND));
        return userDetails(user);
    }

    private UserDetails userDetails(User user) {
        final List<GrantedAuthority> authorities = new ArrayList<>(user.getRole().getAuthorities());
        return new org.springframework.security.core.userdetails.User(user.getLoginId(), user.getPassword(), authorities);
    }
}
