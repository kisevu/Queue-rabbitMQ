package com.ameda.kevin.messagequeue.people.repo;/*
*
@author ameda
@project Queue-rabbitMQ
*
*/

import com.ameda.kevin.messagequeue.people.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,String> {
}
