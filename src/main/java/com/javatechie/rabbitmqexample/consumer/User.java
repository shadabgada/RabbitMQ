package com.javatechie.rabbitmqexample.consumer;

import com.javatechie.rabbitmqexample.config.MessagingConfig;
import com.javatechie.rabbitmqexample.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.javatechie.rabbitmqexample.common.RabbitMQConstants.QUEUE;

@Component
public class User {

    @RabbitListener(queues = QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message received: "+ orderStatus);
    }
}
