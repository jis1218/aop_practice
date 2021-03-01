package com.insup.jung.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MaxCalculatorImpl implements MaxCalculator{

    Log log = LogFactory.getLog(this.getClass());

    @Override
    public double max(double a, double b) {
        log.info("max value");
        return Math.max(a, b);
    }
}
