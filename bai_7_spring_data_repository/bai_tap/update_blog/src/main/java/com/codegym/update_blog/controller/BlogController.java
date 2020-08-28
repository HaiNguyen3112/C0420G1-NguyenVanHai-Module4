package com.codegym.update_blog.controller;


import com.codegym.update_blog.model.Blog;
import com.codegym.update_blog.service.BlogService;
import com.codegym.update_blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/blog")
    public String showList(@RequestParam(name = "title",defaultValue = "")String search, Model model,
                           @PageableDefault(value = 3) Pageable pageable){

        Page<Blog> blogList = blogService.findAllByTitleContaining(search,pageable);

        if (blogList.isEmpty())
            model.addAttribute("message","Blog Empty");

        model.addAttribute("search",search);
        model.addAttribute("blogList",blogList);

        return "blog/list";
    }
    @GetMapping("/blog/sort")
    public String showSortList(@RequestParam(name = "title",defaultValue = "")String search, Model model,
                           @PageableDefault(value = 3) Pageable pageable){

        Page<Blog> blogList = blogService.findAllByTitleContainingOrderByDateAsc(search,pageable);

        if (blogList.isEmpty())
            model.addAttribute("message","Blog Empty");

        model.addAttribute("search",search);
        model.addAttribute("blogList",blogList);

        return "blog/list";
    }

    @GetMapping("/blog/create")
    public String createForm(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList",categoryService.findAllCategory());
        return "blog/create";
    }
    @PostMapping("/blog/create")
    public String create(@ModelAttribute Blog blog,Model model){
        blogService.save(blog);
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList",categoryService.findAllCategory());
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
