package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {
    @GetMapping
    public String showHome(){
        return "show";
    }
    @GetMapping("/save")
    public ModelAndView save(@RequestParam("condiment") String[] condiments ){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("condiments",condiments);
        return modelAndView;
    }
}
