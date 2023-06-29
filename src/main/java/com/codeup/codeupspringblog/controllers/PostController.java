package com.codeup.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping
    @ResponseBody
    public String index() {
        return "Posts index page";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String view(@PathVariable int id) {
        return "Viewing post with ID: " + id;

//        http://localhost:8080/posts/123
    }

    @GetMapping("/create")
    @ResponseBody
    public String createForm() {
        return "Viewing the form for creating a post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String create() {
        return "Creating a new post";
    }
}
