package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    /*
    /hello -> Hello World
    /hello?name=connie -> Hello Connie!
    /hello/connie -> Hello connie
    */

//    @GetMapping("/hello")
//    @ResponseBody
//    public String sayHello(@RequestParam @Nullable String name) {
//        if(name == null) {
//            name = " world";
//        }
//        return "<h1>Hello " + name +  "!</h1>";
//    }
//@GetMapping("/hello/{name}")
//public String sayHello(@PathVariable String name, Model model) {
//    model.addAttribute("name", name);
//    return "hello";
//}

    @GetMapping("/join")
    public String showJoinForm(Model model) {
        List<Item> shoppingCart = new ArrayList<>();
        shoppingCart.add(new Item("screwdriver"));
        shoppingCart.add(new Item("hammer"));
//        shoppingCart.add(new Item("drill"));
        model.addAttribute("shoppingCart", shoppingCart);
        return "join";
    }
    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }



}
