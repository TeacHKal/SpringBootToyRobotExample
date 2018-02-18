package com.teach.toyrobot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerAspect {

    //Pointcuts

    @Pointcut("@annotation(com.teach.toyrobot.aspect.annotations.Logger)")
    public void loggerAnnotation() {}

    //Advices
    @After("loggerAnnotation()")
    public void log(JoinPoint joinPoint){
        //TODO: Need implementation
        //System.out.println("AAAAAAAAAAAAAAA");
    }
}
