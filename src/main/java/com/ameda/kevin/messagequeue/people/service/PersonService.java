package com.ameda.kevin.messagequeue.people.service;/*
*
@author ameda
@project Queue-rabbitMQ
*
*/

import com.ameda.kevin.messagequeue.people.DTO.PersonDTO;
import com.ameda.kevin.messagequeue.people.DTO.PersonResponse;
import com.ameda.kevin.messagequeue.people.config.MQConfig;
import com.ameda.kevin.messagequeue.people.entity.Person;
import com.ameda.kevin.messagequeue.people.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final RabbitTemplate rabbitTemplate;


    public PersonResponse register(PersonDTO dto) {
        Person person = Person.builder()
                .personId(UUID.randomUUID().toString())
                .surname(dto.getSurname())
                .firstName(dto.getFirstName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .build();
        Person savedPerson = personRepository.save(person);
        rabbitTemplate.convertAndSend(
                MQConfig.MESSAGE_EXCHANGE,
                MQConfig.MESSAGE_ROUTING_KEY,
                savedPerson);
        return PersonResponse.builder()
                .email(savedPerson.getEmail())
                .surname(savedPerson.getSurname())
                .build();
    }
}
