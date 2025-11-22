package com.js.exercises.spring.bean;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionBean {
}
