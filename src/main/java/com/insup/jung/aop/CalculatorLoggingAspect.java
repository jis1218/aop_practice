package com.insup.jung.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(1)
public class CalculatorLoggingAspect {

    private Log log = LogFactory.getLog(this.getClass());

    @Before("execution(* ArithmeticCalculator.add(..)) && target(target) && args(a,b)")
    public void logBefore(Object target, double a, double b){
        log.info("hahahahaha " + a + ", " + b);
        log.info("The method add() begins");
    }
//
//    @Before("execution(* ArithmeticCalculator.*(..))")
//    public void logBefore(JoinPoint joinPoint){
//        log.info("=================================================");
//        log.info("The method " + joinPoint.getSignature().getName()
//            + "() begins with " + Arrays.toString(joinPoint.getArgs()) + " get kind = " + joinPoint.getKind());
//    }
//
//    @After("execution(* ArithmeticCalculator.*(..))")
//    public void logAfter(JoinPoint joinPoint){
//        log.info("The method " + joinPoint.getSignature().getName()
//                + "() closes with " + Arrays.toString(joinPoint.getArgs()));
//        log.info("=================================================");
//    }
//
//    @AfterReturning(value = "execution(* ArithmeticCalculator.*(..))", returning = "result")
//    public void logAfterReturning(JoinPoint joinPoint, Object result){
//        log.info("The method " + joinPoint.getSignature().getName()
//                + "() ends with " + Arrays.toString(joinPoint.getArgs()) + " and " + result);
//    }

    @Around("execution(* ArithmeticCalculator.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("감싸주네요");
        log.info(String.format("Join point kind : {%s}", joinPoint.getKind()));
        log.info(String.format("Signature declaring type : {%s}", joinPoint.getSignature().getDeclaringTypeName()));
        log.info(String.format("Signature name : {%s}", joinPoint.getSignature().getName()));
        log.info(String.format("Arguments : {%s}", Arrays.toString(joinPoint.getArgs())));
        log.info(String.format("Target class : {%s}", joinPoint.getTarget().getClass().getName()));
        log.info(String.format("This class : {%s}", joinPoint.getThis().getClass().getName()));

         try{
            Object result = joinPoint.proceed();
            log.info("proceed 다음에 호출");
            return result;
        }catch (IllegalArgumentException e){
             log.error("에러가 났어요");
             throw e;
         }
    }

    @Pointcut("execution(* ArithmeticCalculator.*(..))")
    private void loggingOperation(){}

    @After("loggingOperation()")
    public void logAfter(JoinPoint joinPoint){
        log.info("The method " + joinPoint.getSignature().getName()
                + "() closes with " + Arrays.toString(joinPoint.getArgs()));
        log.info("=================================================");
    }
}
