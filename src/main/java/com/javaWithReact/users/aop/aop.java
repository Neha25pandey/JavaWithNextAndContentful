package com.javaWithReact.users.aop;

import com.javaWithReact.users.entity.Users;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class aop {
   private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* listUsers())")
    public void listUserPointcut(){}

    @Before("listUserPointcut()")
    public void beforeListUsers(JoinPoint joinPoint){
        logger.warn("-----------------------", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
       System.out.println("I am in aop--------------------------------------");

    }

    @AfterReturning(pointcut = "listUserPointcut()",returning = "result" )
    public void afterListUsers(JoinPoint joinPoint,ResponseEntity<List<Users>> result){
        logger.warn("-----------------------", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),"-----------",result);
        System.out.println("I am after aop--------------------------------------");
    }


}
