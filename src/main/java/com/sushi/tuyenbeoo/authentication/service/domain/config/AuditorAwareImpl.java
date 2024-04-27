package com.sushi.tuyenbeoo.authentication.service.domain.config;

import com.sushi.tuyenbeoo.authentication.service.domain.constant.HeaderConstant;
import com.sushi.tuyenbeoo.authentication.service.domain.utils.SecurityUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    private HttpServletRequest requestHeader;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(SecurityUtils.getUser(requestHeader.getHeader(HeaderConstant.REQUEST_JWT)));
    }
}
