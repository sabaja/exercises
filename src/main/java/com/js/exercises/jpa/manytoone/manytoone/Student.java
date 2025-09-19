package com.js.exercises.jpa.manytoone.manytoone;

import jakarta.persistence.*;
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
public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = -4332296986611141682L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "school_id")
    private School school;

    public static final class FIELDS_NAME {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String SCHOOL = "school";
    }
}
