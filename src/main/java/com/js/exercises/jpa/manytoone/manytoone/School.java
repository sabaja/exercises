package com.js.exercises.jpa.manytoone.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class School implements Serializable {

    @Serial
    private static final long serialVersionUID = -8631423144395044452L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    public static final class FIELDS_NAME {
        public static final String ID = "id";
        public static final String NAME = "name";
    }
}
