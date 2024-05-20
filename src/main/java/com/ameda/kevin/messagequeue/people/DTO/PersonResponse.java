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
public class PersonResponse {
    private String surname;
    private String email;
}
