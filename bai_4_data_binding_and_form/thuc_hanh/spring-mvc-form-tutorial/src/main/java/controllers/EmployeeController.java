package controllers;

import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

//    @RequestMapping(value = "showform", method = RequestMethod.GET)
    @GetMapping
    public ModelAndView showForm() {
        ModelAndView modelAndView= new ModelAndView("create","employee",new Employee());
        return modelAndView;
    }

//    @RequestMapping(value = "addEmployee", method = RequestMethod.POST)
    @PostMapping("/addEmployee")
    public ModelAndView submit(@ModelAttribute Employee employee) {
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }
}
