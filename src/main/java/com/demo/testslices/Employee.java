package com.demo.testslices;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Employee {
    @Id
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;
}
