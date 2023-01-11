package com.example.aop.aop;

import com.example.aop.dto.User2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){}

    @Pointcut("@annotation(com.example.aop.annotation.Decode)")
    private void enableDecode(){}

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs();

        for(Object arg : args) {
            if(arg instanceof User2) {
                User2 user2 = User2.class.cast(arg);

                String base64Email = user2.getEmail();
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");
                user2.setEmail(email);
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReuturn(JoinPoint joinPoint, Object returnObj){
        if(returnObj instanceof User2) {
            User2 user2 = User2.class.cast(returnObj);

            String email = user2.getEmail();
            String base64email = Base64.getEncoder().encodeToString(email.getBytes());
            user2.setEmail(base64email);
        }
    }
}
