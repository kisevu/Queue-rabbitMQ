package com.ameda.kevin.messagequeue.people.entity;/*
*
@author ameda
@project message-queue
*
*/

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "people")
@EntityListeners(AuditingEntityListener.class)
public class Person {
    @Id
    private String personId;
    private String firstName;
    private String surname;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;
}
