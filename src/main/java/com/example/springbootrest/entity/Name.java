package com.example.springbootrest.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Name {
    private String firstName;
    private String middleName;
    private String lastName;
}
