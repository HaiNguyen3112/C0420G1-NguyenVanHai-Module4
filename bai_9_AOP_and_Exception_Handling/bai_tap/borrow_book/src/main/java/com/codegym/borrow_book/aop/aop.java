package com.codegym.borrow_book.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class aop {
    @AfterReturning ("execution(public * com.codegym.borrow_book.controller.BookController.borrowBook(..))")
    public void showResultBorrow(){
        System.out.println("Cho muon thanh cong!!!");
    }
    @AfterReturning("execution(public * com.codegym.borrow_book.controller.BookController.giveBackBook(..))")
    public void showResultGiveBack(){
        System.out.println("Tra sach thanh cong!!!");
    }
    @AfterThrowing(value = "execution(public * com.codegym.borrow_book.controller.BookController.borrowBook(..) )", throwing = "e")
    public void show(JoinPoint joinPoint, Exception e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[Hệ Thống] co loi xay ra khi muon sach: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
    @AfterThrowing(value = "execution(public * com.codegym.borrow_book.controller.BookController.giveBackBook(..) )", throwing = "e")
    public void showGiveBack(JoinPoint joinPoint, Exception e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[Hệ Thống] co loi xay ra khi tra sach: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
}
