package com.js.exercises.onetoone;

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
public class ParckingSpot implements Serializable {

    @Serial
    private static final long serialVersionUID = 3700916610762974393L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
