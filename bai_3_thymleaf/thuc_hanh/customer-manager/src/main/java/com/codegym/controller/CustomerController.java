package com.codegym.controller;


import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();

    @GetMapping("/")
    public String index(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers",customers);
        return "index";
    }
    @GetMapping("/customer/create")
    public String createForm(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/customer/save")
    public String save(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customer.setId((int) (Math.random() *10000));
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success","Saved Customer Successfully");
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/edit")
    public String editForm(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }

    @PostMapping("/customer/update")
    public String update(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success","Saved Customer Successfully");
        return "redirect: /";
    }

    @GetMapping("/customer/{id}/delete")
    public String deleteForm(@PathVariable int id, Model model){
//       model.addAttribute("customer", customerService.findById(id));
        customerService.remove(id);
        return "redirect: /";
//       return "delete";
    }

//    @PostMapping("/customer/delete")
//    public String delete(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
//        customerService.remove(customer.getId());
//        redirectAttributes.addFlashAttribute("success","Saved Customer Successfully");
//        return "redirect: /";
//    }

    @GetMapping("/customer/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "view";
    }


}
