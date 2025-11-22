package com.js.exercises.spring.bean;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Scope("prototype")
@RequiredArgsConstructor
public class SpringBeanScopeController {

    private final SingletonBean singletonBean;
    private final PrototypeBean prototypeBean;
    private final RequestBean requestBean;
    private final SessionBean sessionBean;
    private final ApplicationBean applicationBean;

    @GetMapping("tests")
    public String testBeans() {
        return "<pre>" + singletonBean + "\n" + prototypeBean + "\n" +
                requestBean + "\n" + sessionBean + "\n" +
                applicationBean + "</pre>";
    }
}
