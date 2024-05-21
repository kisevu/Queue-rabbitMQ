package com.ameda.kevin.messagequeue.consumer;/*
*
@author ameda
@project Queue-rabbitMQ
*
*/

import com.ameda.kevin.messagequeue.people.config.MQConfig;
import com.ameda.kevin.messagequeue.people.entity.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumePerson {
    private final OrderRepo orderRepo;

    private String surname;
    @RabbitListener(queues = MQConfig.QUEUE)
    public void consumeMessage(Person person){
        log.info("Kevin Ameda has consumed: {}", person.getSurname());
        this.surname = person.getSurname();
    }


    public OrderResponse dispatchOrder(){
        List<String> foods = new ArrayList<>();
        foods.add("chicken thighs");
        foods.add("fries");
        foods.add("dessert");
        Order order = Order.builder()
                .orderId(UUID.randomUUID().toString())
                .orderName("KEVIN")
                .orderDetails(foods)
                .dispatchTime(LocalDateTime.now())
                .dispatcher(surname)
                .build();
       Order  savedOrder = orderRepo.save(order);
        return OrderResponse.builder()
                .dispatcher(null)
                .dispatchTime(null)
                .build();
    }
}
