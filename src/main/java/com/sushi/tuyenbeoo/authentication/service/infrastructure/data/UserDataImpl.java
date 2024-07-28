package com.sushi.tuyenbeoo.authentication.service.infrastructure.data;

import com.sushi.tuyenbeoo.authentication.service.domain.data.UserData;
import com.sushi.tuyenbeoo.authentication.service.domain.entity.User;
import com.sushi.tuyenbeoo.authentication.service.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDataImpl implements UserData {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
