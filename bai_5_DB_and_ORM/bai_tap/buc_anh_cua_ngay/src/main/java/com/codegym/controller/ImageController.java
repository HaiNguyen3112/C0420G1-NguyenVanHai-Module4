package com.codegym.controller;

import com.codegym.model.Comment;
import com.codegym.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ImageController {
    @Autowired
    CommentService commentService;
    @GetMapping("/home")
    public String home( Model model){
        model.addAttribute("comment", new Comment());
        model.addAttribute("commentList", commentService.getAll());
        return "view";
    }

    @PostMapping("/home/comment")
    public String addNewCmt(@ModelAttribute Comment comment){
        commentService.save(comment);
        return "redirect:/home";
    }

    @PostMapping("/home/like/{id}")
    public String updateLike(@PathVariable Long id, Model model){
        Comment comment = commentService.findById(id);
        comment.setTotalLike(comment.getTotalLike()+1);
        commentService.save(comment);

        model.addAttribute("comment", new Comment());
        model.addAttribute("commentList", commentService.getAll());
        return "redirect:/home";
    }
}
