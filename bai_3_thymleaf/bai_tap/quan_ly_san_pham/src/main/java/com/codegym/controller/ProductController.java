package com.codegym.controller;

import com.codegym.Repository.ProductRepository;
import com.codegym.Repository.ProductRepositoryImpl;
import com.codegym.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    private ProductRepository productRepository = new ProductRepositoryImpl();

    @GetMapping("/")
    public String list(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("products",products);
        return "list";
    }
    @GetMapping("/product/create")
    public String createForm(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/product/save")
    public String save(@ModelAttribute Product product){
        product.setId(productRepository.size()+1);
        productRepository.save(product);
        return "redirect:/";
    }
    @GetMapping("/product/{id}/edit")
    public String editForm(@PathVariable int id, Model model){
        model.addAttribute("product",productRepository.findById(id));
        return "edit";
    }

    @PostMapping("product/update")
    public String update(@ModelAttribute Product product){
        productRepository.update(product.getId(),product);
        return "redirect: /";
    }
    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id){
        productRepository.remove(id);
        return "redirect: /";
    }
    @GetMapping("/product/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("product",productRepository.findById(id));
        return "view";
    }

}
