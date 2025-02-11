package com.marcusvbrangel.happyschool.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    Queue paymentQueue() {
        return new Queue("dev.payment.process.v1.queue", true);
    }

    @Bean
    Queue invoiceQueue() {
        return new Queue("dev.invoice.generate.v1.queue", true);
    }

    @Bean
    SimpleMessageListenerContainer paymentContainer(ConnectionFactory connectionFactory,
                                                    MessageListenerAdapter paymentListenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("dev.payment.process.v1.queue");
        container.setMessageListener(paymentListenerAdapter);
        return container;
    }

    @Bean
    SimpleMessageListenerContainer invoiceContainer(ConnectionFactory connectionFactory,
                                                    MessageListenerAdapter invoiceListenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("dev.invoice.generate.v1.queue");
        container.setMessageListener(invoiceListenerAdapter);
        return container;
    }

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin1234");
        return connectionFactory;
    }

    @Bean
    MessageListenerAdapter paymentListenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receivePaymentMessage");
    }

    @Bean
    MessageListenerAdapter invoiceListenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveInvoiceMessage");
    }

}
