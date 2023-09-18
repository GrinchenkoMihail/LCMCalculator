package com.europeana.solution.LCMCalculator.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class TimerAspect {
    private Date start;
    private Date finish;

    @Before("execution(public * com.europeana.solution.LCMCalculator.service.SmallestMultiple.findSmallestMultiple())")
    public void timeBefore(JoinPoint joinPoint){
        start = new Date();
    }

    @AfterReturning(value = "execution(public long com.europeana.solution.LCMCalculator.service..*(..))", returning = "result")
    public void loggingRes(JoinPoint joinPoint, long result){
        finish = new Date();
    }
    public long getSpendTime(){
        return finish.getTime()-start.getTime();
    }

}
