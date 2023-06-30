package com.codeup.codeupspringblog.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public int add(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;

//        http://localhost:8080/math/add/2/and/3
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public int subtract(@PathVariable int num1, @PathVariable int num2) {
        return num2 - num1;

//        http://localhost:8080/math/subtract/2/from/3
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public int multiply(@PathVariable int num1, @PathVariable int num2) {
        return num1 * num2;

//        http://localhost:8080/math/multiply/2/and/3
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public int divide(@PathVariable int num1, @PathVariable int num2) {
        return num1 / num2;

//        http://localhost:8080/math/divide/6/by/3
    }
}
