package com.insup.jung.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component //이게 없으니 applicationEventPublisher가 null이 됨, 왜냐면 Autowired는 Bean 안에서 생성되므로
public class Cashier {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    public void checkout(ShoppingCart cart) throws IOException {
        CheckoutEvent event = new CheckoutEvent(cart, new Date());
        System.out.println(applicationEventPublisher);
        applicationEventPublisher.publishEvent(event);
    }
}
