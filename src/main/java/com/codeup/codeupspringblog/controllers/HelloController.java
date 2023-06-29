package com.codeup.codeupspringblog.controllers;

import jakarta.annotation.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    /*
    /hello -> Hello World
    /hello?name=connie -> Hello Connie!
    /hello/connie -> Hello connie
    */

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(@RequestParam @Nullable String name) {
        if(name == null) {
            name = " world";
        }
        return "<h1>Hello " + name +  "!</h1>";
    }

}
