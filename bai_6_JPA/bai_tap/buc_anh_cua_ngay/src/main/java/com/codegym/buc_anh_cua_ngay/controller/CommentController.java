package com.codegym.buc_anh_cua_ngay.controller;

import com.codegym.buc_anh_cua_ngay.model.Comment;
import com.codegym.buc_anh_cua_ngay.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/home")
    public String home( Model model){
        model.addAttribute("comment", new Comment());
        model.addAttribute("commentList", commentService.findAll());
        return "view";
    }

    @PostMapping("/home/comment")
    public String addNewCmt(@ModelAttribute Comment comment){
        commentService.save(comment);
        return "redirect:/home";
    }

    @PostMapping("/home/like/{id}")
    public String updateLike(@PathVariable Long id, Model model, RedirectAttributes redirect){
        Comment comment = commentService.findById(id);
        if (comment != null){
            comment.setTotalLike(comment.getTotalLike()+1);
            commentService.save(comment);

            model.addAttribute("comment", new Comment());
            model.addAttribute("commentList", commentService.findAll());
        } else {
            redirect.addFlashAttribute("message","Comment not found or deleted!!!");
        }

        return "redirect:/home";
    }
}
