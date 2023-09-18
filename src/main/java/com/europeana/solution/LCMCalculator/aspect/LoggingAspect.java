package com.europeana.solution.LCMCalculator.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(public * com.europeana.solution.LCMCalculator.controllers..*(..))")
    public void loggingBeforeController(JoinPoint joinPoint){
        String args = Arrays.stream(joinPoint.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        log.info(joinPoint + " InPut range: " + args);
    }

    @AfterReturning(value = "execution(public long com.europeana.solution.LCMCalculator.service..*(..))", returning = "result")
    public void loggingAfterCalculate(JoinPoint joinPoint, long result){
        log.info(joinPoint.toString() + " Return result: "+ result);
    }

}
