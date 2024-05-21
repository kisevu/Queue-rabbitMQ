package com.ameda.kevin.messagequeue.people.controller;/*
*
@author ameda
@project message-queue
*
*/

import com.ameda.kevin.messagequeue.consumer.ConsumePerson;
import com.ameda.kevin.messagequeue.people.DTO.PersonDTO;
import com.ameda.kevin.messagequeue.people.DTO.PersonResponse;
import com.ameda.kevin.messagequeue.people.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;
    private final ConsumePerson consumePerson;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody PersonDTO dto){
        PersonResponse response = personService.register(dto);
        if(response==null){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
    }
    @PostMapping("/order")
    public ResponseEntity<?> order(){
        return ResponseEntity.ok()
                .body(consumePerson.dispatchOrder());
    }
}
