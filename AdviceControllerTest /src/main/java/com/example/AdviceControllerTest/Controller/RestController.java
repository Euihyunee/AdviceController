package com.example.AdviceControllerTest.Controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @ExceptionHandler(NullPointerException.class)
    public Object nullex(Exception e){
        System.err.println(e.getClass());
        return "myService";
    }
}
