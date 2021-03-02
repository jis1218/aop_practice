package com.insup.jung;

import com.insup.jung.aop.ArithmeticCalculator;
import com.insup.jung.aop.ArithmeticCalculatorImpl;
import com.insup.jung.aop.MaxCalculator;
import com.insup.jung.event.Cashier;
import com.insup.jung.event.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRun implements ApplicationRunner {

    @Autowired
    ArithmeticCalculatorImpl impl;

    @Autowired
    ArithmeticCalculator calculator;

    @Autowired Cashier cashier;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        impl.add(3, 6);
//        impl.sub(5,3);
//
//        MaxCalculator maxCalculator = (MaxCalculator) calculator;
//        maxCalculator.max(1, 2);
        cashier.checkout(new ShoppingCart());

    }
}
