package dev.alanosms.rabbitmqconsumer.consumer;

import dev.alanosms.rabbitmqconsumer.model.DeviceMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "myQueue")
    public void receiveMessage(DeviceMessage message) {
        System.out.println("Received message: " + message);
        System.out.println("Device ID: " + message.getDeviceId());
        System.out.println("Timestamp: " + message.getTimestamp());
        System.out.println("Message: " + message.getMessage());
    }
}