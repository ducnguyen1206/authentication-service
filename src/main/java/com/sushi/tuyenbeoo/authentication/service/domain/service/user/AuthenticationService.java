package com.sushi.tuyenbeoo.authentication.service.domain.service.user;

import com.sushi.tuyenbeoo.authentication.service.domain.dto.request.AuthenticationRequest;
import com.sushi.tuyenbeoo.authentication.service.domain.dto.request.RegisterRequest;
import com.sushi.tuyenbeoo.authentication.service.domain.dto.response.AuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    void refreshToken(HttpServletRequest request, HttpServletResponse response);
}
