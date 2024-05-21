package com.ameda.kevin.messagequeue.consumer;/*
*
@author ameda
@project Queue-rabbitMQ
*
*/

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderResponse {
    private String dispatcher;
    private LocalDate dispatchTime;
}
