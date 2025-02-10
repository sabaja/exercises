package com.js.exercises.onetomany;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Department implements Serializable {

    @Serial
    private static final long serialVersionUID = -7004458730436243902L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "department_id")
    private List<Employee> employees;
}
