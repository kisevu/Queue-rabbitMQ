package com.ameda.kevin.messagequeue.logic;/*
*
@author ameda
@project message-queue
*
*/

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MessageEntity {
    private String messageId;
    private String message;
    private Date messageDate;
}
