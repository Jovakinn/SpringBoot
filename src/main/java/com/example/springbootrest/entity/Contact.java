package com.example.springbootrest.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.Table;
import java.net.URL;

@Table(name = "Contact")
@Data
public class Contact {
    @Id
    @Basic
    private Integer id;

    @Basic
    private Name name;

    @Basic
    private String notes;

    @Basic
    private URL website;
}
