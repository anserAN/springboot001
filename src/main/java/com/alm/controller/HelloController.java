package com.alm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author anluming
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String say(){
        return "hello.html";
    }
}
