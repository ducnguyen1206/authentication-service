package com.sushi.tuyenbeoo.authentication.service.application.controller;

import com.sushi.tuyenbeoo.authentication.service.domain.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sushi.tuyenbeoo.authentication.service.application.constant.UrlConstant.LOGIN_URI;
import static com.sushi.tuyenbeoo.authentication.service.application.constant.UrlConstant.USER_CONTROLLER;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping(USER_CONTROLLER)
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping(LOGIN_URI)
    @Operation(summary = "User login")
    public ResponseEntity<Object> login() {
        return ResponseEntity.ok().build();
    }
}
