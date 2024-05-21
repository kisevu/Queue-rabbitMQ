package com.ameda.kevin.messagequeue.consumer;/*
*
@author ameda
@project Queue-rabbitMQ
*
*/

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDto {
    private String orderName;
    private List<String> orderDetails = new ArrayList<>();
}
