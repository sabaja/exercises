package com.js.exercises.jpa.manytoone.onetoone;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CoOwner implements Serializable {

    @Serial
    private static final long serialVersionUID = -2536999946716709190L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String address;

    @OneToOne
    @JoinColumn(name = "parcking_spot_id")
    private ParckingSpot parckingSpot;

}
