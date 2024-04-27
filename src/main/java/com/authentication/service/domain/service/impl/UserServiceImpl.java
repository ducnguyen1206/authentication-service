package com.authentication.service.domain.service.impl;

import com.authentication.service.domain.data.UserData;
import com.authentication.service.domain.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserData userData;

}
