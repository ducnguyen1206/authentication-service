package com.sushi.tuyenbeoo.authentication.service.infrastructure.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    /**
     * Pointcut that matches all repositories, services, and WEB REST enpoints
     */
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *) || " +
            "within(@org.springframework.stereotype.Service *) ||" +
            "within(@org.springframework.stereotype.Repository *)")
    public void springBeanPointCut() {

    }

    /**
     * Pointcut that matches all spring beans in the application's main packages
     */
    @Pointcut("within(com.sushi.tuyenbeoo.authentication.service.application.controller..*) || " +
            "within(com.sushi.tuyenbeoo.authentication.service.domain.service.impl..*) ||" +
            "within(com.sushi.tuyenbeoo.authentication.service.infrastructure.data..*) ||" +
            "within(com.sushi.tuyenbeoo.authentication.service.infrastructure.repository..*)")
    public void applicationPointCut() {

    }

    private Logger logger(JoinPoint joinPoint) {
        return LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringTypeName());
    }

    /**
     * Advice that logs when a method is entered and exited
     */
    @Around("springBeanPointCut() && applicationPointCut()")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger log = logger(joinPoint);
        String args = Arrays.toString(joinPoint.getArgs());
        log.info("Enter: {}() with arguments[s] {}", joinPoint.getSignature().getName(), args);
        Object result = joinPoint.proceed();
        log.info("Exit: {}() with result = {}", joinPoint.getSignature().getName(), result);
    }

    /**
     * Advice that logs methods is thrown exception
     */
    @AfterThrowing(pointcut = "springBeanPointCut() && applicationPointCut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        logger(joinPoint).error("Exception in {}() with cause =\"{}\" and exception =\"{}\"",
                joinPoint.getSignature().getName(),
                e.getCause() != null ? e.getCause() : "NULL",
                e.getMessage(), e);
    }
}
