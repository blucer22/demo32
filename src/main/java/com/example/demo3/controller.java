package com.example.demo3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @RequestMapping( value="/login", method = RequestMethod.GET )
    public String hello12(){
        return "hello world springboot project12";
    }
}
