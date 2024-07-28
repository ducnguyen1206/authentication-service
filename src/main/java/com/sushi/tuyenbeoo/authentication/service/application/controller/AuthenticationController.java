package com.sushi.tuyenbeoo.authentication.service.application.controller;

import com.sushi.tuyenbeoo.authentication.service.domain.dto.request.AuthenticationRequest;
import com.sushi.tuyenbeoo.authentication.service.domain.dto.request.RegisterRequest;
import com.sushi.tuyenbeoo.authentication.service.domain.dto.response.AuthenticationResponse;
import com.sushi.tuyenbeoo.authentication.service.domain.service.user.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sushi.tuyenbeoo.authentication.service.application.constant.UrlConstant.*;

@RestController
@AllArgsConstructor
@RequestMapping(AUTH_CONTROLLER)
public class AuthenticationController {

    @Autowired
    private final AuthenticationService authenticationService;

    @PostMapping(REGISTER_URI)
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping(LOGIN_URI)
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PutMapping(TOKEN_URI)
    public ResponseEntity<Void> refreshToken(HttpServletRequest request, HttpServletResponse response) {
        authenticationService.refreshToken(request, response);
        return ResponseEntity.noContent().build();
    }
}
