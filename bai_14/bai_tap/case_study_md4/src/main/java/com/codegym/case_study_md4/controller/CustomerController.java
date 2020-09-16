package com.codegym.case_study_md4.controller;

import com.codegym.case_study_md4.model.Customer;
import com.codegym.case_study_md4.service.CustomerService;
import com.codegym.case_study_md4.service.TypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    TypeCustomerService typeCustomerService;


    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/customer")
    public String showList(@RequestParam(name = "name",defaultValue = "")String search, Model model,
                           @PageableDefault(value = 4) Pageable pageable){
        Page<Customer> customerList = customerService.findAllByNameContaining(search,pageable);
        if (customerList.isEmpty())
            model.addAttribute("message","Customer List Empty");
        model.addAttribute("search",search);
        model.addAttribute("customerList",customerList);

        return "customer/list";
    }
    @PostMapping("/customer/search")
    public String getSearch(@RequestParam(name = "name",defaultValue = "")String search, Model model,
                           @PageableDefault(value = 4) Pageable pageable){
        Page<Customer> customerList = customerService.findAllByNameContaining(search,pageable);
        if (customerList.isEmpty())
            model.addAttribute("message","Not Found");
        model.addAttribute("search",search);
        model.addAttribute("customerList",customerList);

        return "customer/list";
    }

    @GetMapping("/customer/view/{id}")
    public String view(@PathVariable Long id,Model model, RedirectAttributes redirect){
        Customer customer = customerService.findById(id);
        if (customer != null){
            model.addAttribute("customer", customer);
            return "customer/view";
        } else {
            redirect.addFlashAttribute("message","Not found or Customer you choose not exist!!!");
            return "redirect:/customer";
        }
    }

    @GetMapping("/customer/create")
    public String createForm(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("typeCustomerList",typeCustomerService.findAll());
        return "customer/create";
    }

    @PostMapping("/customer/create")
    public String create(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, Model model){
        new Customer().validate(customer,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("messageCode","Code is exist!!!");
            model.addAttribute("typeCustomerList",typeCustomerService.findAll());
        }
        else{
            try {
                customerService.save(customer);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                model.addAttribute("typeCustomerList",typeCustomerService.findAll());
                return "customer/create";
            }

            model.addAttribute("customer", new Customer());
            model.addAttribute("typeCustomerList",typeCustomerService.findAll());
            model.addAttribute("message","Successful");
        }
        return "customer/create";

    }

    @GetMapping("/customer/edit/{id}")
    public String editForm(@PathVariable Long id, Model model, RedirectAttributes redirect){
        Customer customer = customerService.findById(id);
        model.addAttribute("typeCustomerList",typeCustomerService.findAll());
        if (customer != null){
            model.addAttribute("customer", customer);
            return "customer/edit";
        } else {
            redirect.addFlashAttribute("message","Not found or Blog you choose not exist!!!");
            return "redirect:/customer";
        }

    }

    @PostMapping("/customer/edit")
    public String edit(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirect){
        new Customer().validate(customer,bindingResult);
        if (bindingResult.hasFieldErrors()){
            redirect.addFlashAttribute("message","Can Not Change Information because wrong input!!!");
        }else {
            customerService.save(customer);
        }
        return "redirect:/customer";

    }

    @GetMapping("/customer/delete/{id}")
    public String delete(@PathVariable Long id){
        customerService.deleteById(id);
        return "redirect:/customer";
    }
}
