package com.queue.rabbitmqproducerconsumer.api;

import com.queue.rabbitmqproducerconsumer.producer.Producer;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("RabbitmqproducerconsumerApi")
@RequestMapping("/v1")
@Validated
public class RabbitproducerconsumerApi {

    @Autowired
    private Producer producer;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/sendMessage")
    @ApiOperation(value = "Send message to queue")
    public ResponseEntity<String> sendMessage(String message) {

        producer.send("excahnge", "routingKey", message);

        return ResponseEntity.ok().build();
    }

}
