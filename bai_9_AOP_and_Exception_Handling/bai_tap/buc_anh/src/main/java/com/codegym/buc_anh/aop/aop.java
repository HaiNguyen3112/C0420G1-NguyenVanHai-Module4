package com.codegym.buc_anh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


import java.util.Arrays;

@Aspect
@Component
public class aop {
    @AfterReturning(  "execution(public * com.codegym.buc_anh.service.CommentServiceImpl.save(..))")
    public void showError(JoinPoint joinPoint){
        System.out.println("Done!!!");
    }
    @AfterThrowing(value = "execution(public * com.codegym.buc_anh.controller.CommentController.addNewCmt(..))", throwing = "e")
    public void show(JoinPoint joinPoint, Exception e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[Hệ Thống] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
}
