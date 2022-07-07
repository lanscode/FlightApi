package com.koria.api.reservation.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    /**
     * Pointcut that matches all Spring beans in the application's main packages.
     */
    @Pointcut(" within(com.koria.api.reservation.service..*)" +
        " || within(com.koria.api.reservation.controller..*)"
    		+"||within(com.koria.api.reservation.config..*)")
    public void applicationPackagePointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }
	  /**
     * Advice that logs methods throwing exceptions.
     * @param joinPoint join point for advice
     * @param e exception
     */
    @AfterThrowing(pointcut = "applicationPackagePointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
            joinPoint.getSignature().getName(), e.getMessage() != null ? e.getMessage() : "NULL");
    }


}
