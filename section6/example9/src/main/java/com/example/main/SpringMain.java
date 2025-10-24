package com.example.main;

import com.example.beans.MyService;
import com.example.beans.UserSession;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        /*
        if the beans is stateless
        (not going to store any kind of data),
        use default singleton scope (ideal for immutable objects)
        for example in business logic with java methods

        if the beans is stateful
        (will storing any kind of data, which is going to be different for different users),
        use prototype singleton scope (ideal for mutable objects)

        prototype scope rarely used in application,
        only used in the scenarios where you need a new instance each time,
        such as an object representing user input
         */

        /* default singleton scope
        MyService service1 = context.getBean(MyService.class);
        MyService service2 = context.getBean(MyService.class);
        */

        //prototype scope
        UserSession user1 = context.getBean(UserSession.class);
        UserSession user2 = context.getBean(UserSession.class);
        System.out.println(user1 == user2); //Comparing hash code
        System.out.println(user1.getSessionId());
        System.out.println(user2.getSessionId());
    }
}
