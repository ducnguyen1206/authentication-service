package com.sushi.tuyenbeoo.authentication.service.application.controller;

import com.sushi.tuyenbeoo.authentication.service.domain.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sushi.tuyenbeoo.authentication.service.application.constant.UrlConstant.USER_CONTROLLER;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping(USER_CONTROLLER)
public class UserController {

    @Autowired
    private final UserService userService;
}
