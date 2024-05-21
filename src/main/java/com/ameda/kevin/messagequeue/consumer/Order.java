package com.ameda.kevin.messagequeue.consumer;/*
*
@author ameda
@project Queue-rabbitMQ
*
*/

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
    @Id
    private String orderId;
    private String dispatcher;
    private String orderName;
    private List<String> orderDetails = new ArrayList<>();
    private LocalDateTime dispatchTime;
}
