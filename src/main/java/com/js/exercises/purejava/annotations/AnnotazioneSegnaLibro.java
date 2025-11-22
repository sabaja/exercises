package com.js.exercises.purejava.annotations;

//import module java.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Annotazione vuota
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface AnnotazioneSegnaLibro {
}
