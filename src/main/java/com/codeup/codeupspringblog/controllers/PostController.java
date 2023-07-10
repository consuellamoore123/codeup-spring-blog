package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.models.EmailService;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostRepository postDao;
    private UserRepository userDao;
    private EmailService emailService;

    @GetMapping("")
    public String posts(Model model){
        List<Post> posts = postDao.findAll();

        model.addAttribute("posts",posts);
        return "/posts/index";
    }

    @GetMapping("/{id}")
    public String showSinglePost(@PathVariable Long id, Model model){
        // find the desired post in the db
        Optional<Post> optionalPost = postDao.findById(id);
        if(optionalPost.isEmpty()) {
            System.out.printf("Post with id " + id + " not found!");
            return "home";
        }

        // if we get here, then we found the post. so just open up the optional
        model.addAttribute("post", optionalPost.get());
        return "/posts/show";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute("post") Post post) {
        savePost(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Post> optionalPost = postDao.findById(id);
        if (optionalPost.isEmpty()) {
            System.out.printf("Post with id " + id + " not found!");
            return "/home";
        }

        model.addAttribute("post", optionalPost.get());
        return "/posts/edit";
    }

    @PostMapping("/{id}/edit")
    public String updatePost(@PathVariable Long id, @ModelAttribute("post") Post updatedPost) {
        Optional<Post> optionalPost = postDao.findById(id);
        if (optionalPost.isEmpty()) {
            System.out.printf("Post with id " + id + " not found!");
            return "/home";
        }

        Post existingPost = optionalPost.get();
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setBody(updatedPost.getBody());
        savePost(existingPost);

        return "redirect:/posts/" + id;
    }


//



    private void savePost(Post post) {
        // TODO: use user id 1 for now. change later to currently logged in user
        User loggedInUser = userDao.findById(1L).get();
        post.setCreator(loggedInUser);
        emailService.prepareAndSend(post, post.getTitle(), post.getBody());
        postDao.save(post);
    }

}