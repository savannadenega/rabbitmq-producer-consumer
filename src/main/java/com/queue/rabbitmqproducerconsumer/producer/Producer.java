package com.queue.rabbitmqproducerconsumer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private Logger logger = LoggerFactory.getLogger(Producer.class);

    private RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
    }

    public void send(String exchange, String routingKey, String message) {
        this.logger.info("RabbitMQ - Message sent sucessfully: {}", message);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
