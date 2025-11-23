package com.js.exercises.spring.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;


//https://www.youtube.com/watch?v=IOWbaVf9M6U
@Configuration
@ConditionalOnProperty(
        value = "is.avaible",
        havingValue = "true",
        matchIfMissing = false
)
public class OnPropertyConfiguration {
}
