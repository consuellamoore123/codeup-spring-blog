package com.codeup.codeupspringblog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    public int add(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;

//        http://localhost:8080/math/add/2/and/3
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    public int subtract(@PathVariable int num1, @PathVariable int num2) {
        return num2 - num1;

//        http://localhost:8080/math/subtract/2/from/3
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    public int multiply(@PathVariable int num1, @PathVariable int num2) {
        return num1 * num2;

//        http://localhost:8080/math/multiply/2/and/3
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    public int divide(@PathVariable int num1, @PathVariable int num2) {
        return num1 / num2;

//        http://localhost:8080/math/divide/6/by/3
    }
}
