package com.js.exercises.purejava.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotazioneCompleta {
    String descrizione();

    String assegnatoA() default "Da assegnare";

    enum Priorita {BASSA, MEDIA, ALTA}

}
