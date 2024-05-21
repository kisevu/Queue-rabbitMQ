package com.ameda.kevin.messagequeue.consumer;/*
*
@author ameda
@project Queue-rabbitMQ
*
*/

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<Order,String> {
}
