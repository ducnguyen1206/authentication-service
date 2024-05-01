package com.sushi.tuyenbeoo.authentication.service.infrastructure.data;

import com.sushi.tuyenbeoo.authentication.service.domain.entity.Role;
import com.sushi.tuyenbeoo.authentication.service.domain.entity.RestaurantUser;
import com.sushi.tuyenbeoo.authentication.service.domain.entity.UserRole;
import com.sushi.tuyenbeoo.authentication.service.domain.enumf.ErrorEnum;
import com.sushi.tuyenbeoo.authentication.service.domain.exception.GenericException;
import com.sushi.tuyenbeoo.authentication.service.infrastructure.repository.RoleRepository;
import com.sushi.tuyenbeoo.authentication.service.infrastructure.repository.UserRepository;
import com.sushi.tuyenbeoo.authentication.service.infrastructure.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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

    @Autowired
    private final UserRoleRepository userRoleRepository;

    @Autowired
    private final RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RestaurantUser user = userRepository.findByLoginId(username).orElseThrow(() -> new GenericException(ErrorEnum.USER_NAME_NOT_FOUND));
        UserRole userRole = userRoleRepository.findByUserId(user.getId()).orElseThrow(() -> new GenericException(ErrorEnum.ROLE_NOT_FOUND));
        Role role = roleRepository.findById(userRole.getUserId().getId()).orElseThrow(() -> new GenericException(ErrorEnum.ROLE_NOT_FOUND));
        return userDetails(user, role);
    }

    private UserDetails userDetails(RestaurantUser user, Role role) {
        final List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getName()));
        return new User(user.getLoginId(), user.getPassword(), authorities);
    }
}
