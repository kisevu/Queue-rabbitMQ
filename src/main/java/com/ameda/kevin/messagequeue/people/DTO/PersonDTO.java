package com.ameda.kevin.messagequeue.people.DTO;/*
*
@author ameda
@project Queue-rabbitMQ
*
*/


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PersonDTO {
    private String firstName;
    private String surname;
    private String email;
    private String phoneNumber;
}
