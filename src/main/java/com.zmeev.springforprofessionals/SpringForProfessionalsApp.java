package com.zmeev.springforprofessionals;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringForProfessionalsApp {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer mr = context.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}