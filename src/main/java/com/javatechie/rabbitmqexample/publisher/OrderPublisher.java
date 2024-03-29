package com.javatechie.rabbitmqexample.publisher;

import com.javatechie.rabbitmqexample.config.MessagingConfig;
import com.javatechie.rabbitmqexample.dto.Order;
import com.javatechie.rabbitmqexample.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.javatechie.rabbitmqexample.common.RabbitMQConstants.EXCHANGE;
import static com.javatechie.rabbitmqexample.common.RabbitMQConstants.ROUTING_KEY;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable  String restaurantName) {

        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed successfully in "+restaurantName);

        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, orderStatus);

        return "Success!! ";
    }
}
