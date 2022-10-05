package com.idpuwid.notification.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderNotificationListener {

    @KafkaListener(
            topics = "notification",
            groupId = "groupId"
    )
    public void listener(String data){
        log.info("Sending Notification to Email and Whatsapp...");
        log.info("Data: {}", data);
    }
}
