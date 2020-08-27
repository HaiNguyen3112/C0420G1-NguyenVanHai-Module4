package com.codegym.blog_management.controller;

import com.codegym.blog_management.model.Blog;
import com.codegym.blog_management.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @GetMapping("/blog/search")
    public String sortList(@RequestParam String title, Model model){
        List<Blog> blogList = blogService.findAllByTitleContainingOrderByTitleAsc(title);
        model.addAttribute("blogList",blogList);
        return "blog/list";
    }
    @GetMapping("/blog/create")
    public String createForm(Model model){
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }
    @PostMapping("/blog/create")
    public String create(@ModelAttribute Blog blog,Model model){
        blogService.save(blog);
        model.addAttribute("message","Successful");
        return "blog/create";
    }
    @GetMapping("/blog/view/{id}")
    public String view(@PathVariable Long id,Model model, RedirectAttributes redirect){
        Blog blog = blogService.findById(id);
        if (blog != null){
            model.addAttribute("blog", blog);
            return "blog/view";
        } else {
            redirect.addFlashAttribute("message","Not found or Blog you choose not exist!!!");
            return "redirect:/blog";
        }
    }
    @GetMapping("/blog/edit/{id}")
    public String editForm(@PathVariable Long id, Model model, RedirectAttributes redirect){
        Blog blog = blogService.findById(id);
        if (blog != null){
            model.addAttribute("blog", blog);
            return "blog/edit";
        } else {
            redirect.addFlashAttribute("message","Not found or Blog you choose not exist!!!");
            return "redirect:/blog";
        }

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
