package com.sushi.tuyenbeoo.authentication.service.infrastructure.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    private HttpServletRequest requestHeader;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("System");
    }
}
