package dev.alanosms.rabbitmqconsumer.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DeviceMessage {
    private String deviceId;
    private LocalDateTime timestamp;
    private String message;
}