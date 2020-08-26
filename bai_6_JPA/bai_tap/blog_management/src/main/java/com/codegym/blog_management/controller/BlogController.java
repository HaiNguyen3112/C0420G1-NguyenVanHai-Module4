package com.codegym.blog_management.controller;

import com.codegym.blog_management.model.Blog;
import com.codegym.blog_management.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/blog")
    public String showList(Model model){
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList",blogList);
        return "blog/list";
    }
    @GetMapping("/blog/create")
    public String createForm(Model model){
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }
    @PostMapping("/blog/create")
    public String create(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "blog/create";
    }
    @GetMapping("/blog/view/{id}")
    public String view(@PathVariable Long id,Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/view";
    }
    @GetMapping("/blog/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/edit";
    }

    @PostMapping("/blog/edit")
    public String edit(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/blog/delete/{id}")
    public String delete(@PathVariable Long id){
        blogService.remove(id);
        return "redirect:/blog";
    }
}
