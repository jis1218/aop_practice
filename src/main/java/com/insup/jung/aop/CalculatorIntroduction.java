package com.insup.jung.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorIntroduction {

    @DeclareParents(value = "com.insup.jung.aop.ArithmeticCalculatorImpl", defaultImpl = MaxCalculatorImpl.class)
    public MaxCalculator maxCalculator;

    @DeclareParents(value = "ArithmeticCalculatorImpl", defaultImpl = MaxCalculatorImpl.class)
    public MinCalculator minCalculator;
}
