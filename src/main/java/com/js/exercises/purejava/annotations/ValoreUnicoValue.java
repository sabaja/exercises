package com.js.exercises.purejava.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ValoreUnicoValue {
    Valore value();

    enum Valore {A, B, C}

}
