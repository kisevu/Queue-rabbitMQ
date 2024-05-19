package com.ameda.kevin.messagequeue.logic;/*
*
@author ameda
@project message-queue
*
*/

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/messaging")
@RequiredArgsConstructor
public class MessagePublisher {
    private final RabbitTemplate rabbitTemplate;


    @PostMapping("/publish")
    public String publishMessage(@RequestBody  MessageEntity messageEntity){
        messageEntity = MessageEntity.builder()
                .messageId(UUID.randomUUID().toString())
                .message(messageEntity.getMessage())
                .messageDate(new Date())
                .build();
        rabbitTemplate.convertAndSend(
                MQConfig.MESSAGE_EXCHANGE,
                MQConfig.MESSAGE_ROUTING_KEY,
                messageEntity);
        return "Message published successfully.";
    }
}
