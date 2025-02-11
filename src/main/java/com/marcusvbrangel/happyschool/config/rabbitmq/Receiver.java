package com.marcusvbrangel.happyschool.config.rabbitmq;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

    public void receivePaymentMessage(byte[] message) {
        String messageStr = new String(message);
        System.out.println("Received Payment <" + messageStr + ">");
    }

    public void receiveInvoiceMessage(byte[] message) {
        String messageStr = new String(message);
        System.out.println("Received Invoice <" + messageStr + ">");
    }

}
