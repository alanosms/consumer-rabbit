package dev.alanosms.rabbitmqconsumer.controller;

import dev.alanosms.rabbitmqconsumer.model.DeviceMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public ResponseEntity<String> addMessage(@RequestBody DeviceMessage message) {
        message.setTimestamp(LocalDateTime.now());

        rabbitTemplate.convertAndSend("myQueue", message);

        return ResponseEntity.ok("Mensagem enviada com sucesso");
    }
}