package com.js.exercises.jpa.manytoone.onetomany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 4652394389873191323L;

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;
    private String name;
    private Double salary;

}


