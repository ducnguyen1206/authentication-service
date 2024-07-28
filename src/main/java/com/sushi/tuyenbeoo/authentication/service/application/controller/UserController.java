package com.sushi.tuyenbeoo.authentication.service.application.controller;

import com.sushi.tuyenbeoo.authentication.service.domain.service.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.sushi.tuyenbeoo.authentication.service.application.constant.UrlConstant.USER_CONTROLLER;

@RestController
@AllArgsConstructor
@RequestMapping(USER_CONTROLLER)
@Log4j2
public class UserController {

    private final Map<Integer, Map<String, Integer>> simpleMap;

    @Autowired
    private final UserService userService;
}
