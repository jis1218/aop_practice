package com.insup.jung;

import com.insup.jung.aop.ArithmeticCalculatorImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ApplicationTest {

    @Autowired
    ArithmeticCalculatorImpl impl;

    @Test
    public void Before테스트(){
        impl.add(3, 5);
    }
}
