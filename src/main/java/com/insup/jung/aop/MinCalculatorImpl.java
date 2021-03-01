package com.insup.jung.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MinCalculatorImpl implements MinCalculator{

    Log log = LogFactory.getLog(this.getClass());

    @Override
    public double min(double a, double b) {
        log.info("min value");
        return Math.min(a, b);
    }
}
