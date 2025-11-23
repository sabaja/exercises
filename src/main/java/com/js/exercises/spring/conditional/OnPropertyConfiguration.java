package com.js.exercises.spring.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(
        value = "is.avaible",
        havingValue = "true",
        matchIfMissing = false
)
public class OnPropertyConfiguration {
}
