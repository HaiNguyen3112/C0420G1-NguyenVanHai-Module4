package com.codegym.case_study.controller;

import com.codegym.case_study.model.Customer;
import com.codegym.case_study.model.Servicee;
import com.codegym.case_study.service.ServiceService;
import com.codegym.case_study.service.TypeRentService;
import com.codegym.case_study.service.TypeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ServiceController {
    @Autowired
    ServiceService serviceService;
    @Autowired
    TypeServiceService typeServiceService;
    @Autowired
    TypeRentService typeRentService;

    @GetMapping("/service")
    public String showList(@RequestParam(name = "name",defaultValue = "")String search, Model model,
                           @PageableDefault(value = 4) Pageable pageable){

        Page<Servicee> serviceList = serviceService.findAllByNameContainingAndStatusTrue(search,pageable);
        if (serviceList.isEmpty())
            model.addAttribute("message","Service List Empty");
        model.addAttribute("search",search);
        model.addAttribute("serviceList",serviceList);

        return "service/list";
    }

    @GetMapping("/service/view/{id}")
    public String view(@PathVariable Long id, Model model, RedirectAttributes redirect){
        Servicee service = serviceService.findById(id);
        if (service != null){
            model.addAttribute("service", service);
            return "service/view";
        } else {
            redirect.addFlashAttribute("message","Not found or Service you choose not exist!!!");
            return "redirect:/service";
        }
    }

    @GetMapping("/service/create")
    public String createForm(Model model){
        model.addAttribute("service", new Servicee());
        model.addAttribute("typeServiceList",typeServiceService.findAll());
        model.addAttribute("typeRentList",typeRentService.findAll());
        return "service/create";
    }

    @PostMapping("/service/create")
    public String create(@ModelAttribute Servicee service, Model model){
        serviceService.save(service);
        model.addAttribute("service", new Servicee());
        model.addAttribute("typeServiceList",typeServiceService.findAll());
        model.addAttribute("typeRentList",typeRentService.findAll());
        model.addAttribute("message","Successful");
        return "service/create";
    }

    @GetMapping("/service/edit/{id}")
    public String editForm(@PathVariable Long id, Model model, RedirectAttributes redirect){
        Servicee service = serviceService.findById(id);
        model.addAttribute("typeServiceList",typeServiceService.findAll());
        model.addAttribute("typeRentList",typeRentService.findAll());
        if (service != null){
            model.addAttribute("service", service);
            return "service/edit";
        } else {
            redirect.addFlashAttribute("message","Not found or Service you choose not exist!!!");
            return "redirect:/service";
        }

    }

    @PostMapping("/service/edit")
    public String edit(@ModelAttribute Servicee service){
        serviceService.save(service);
        return "redirect:/service";
    }

    @GetMapping("/service/delete/{id}")
    public String delete(@PathVariable Long id){
        Servicee service = serviceService.findById(id);
        service.setStatus(false);
        serviceService.save(service);
        return "redirect:/service";
    }
}
