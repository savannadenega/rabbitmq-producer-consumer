package com.queue.rabbitmqproducerconsumer.producer.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {

    private String exchange = "exchange";

    @Bean(name = "topicRabbitmq")
    public TopicExchange topicExchange() {
        return new TopicExchange(exchange);
    }

}
