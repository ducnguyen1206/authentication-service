package com.sushi.tuyenbeoo.authentication.service.domain.service.impl;

import com.sushi.tuyenbeoo.authentication.service.domain.data.UserData;
import com.sushi.tuyenbeoo.authentication.service.domain.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserData userData;

}
