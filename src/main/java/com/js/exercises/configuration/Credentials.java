package com.js.exercises.configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Credentials {
    private String username;
    private String password;
    private String authMethod;
}
