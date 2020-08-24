package controllers;

import model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.EmailService;
import service.EmailServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {
    EmailService emailService = new EmailServiceImpl();
    @GetMapping("/create")
    public ModelAndView showCreate(Model model){
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        model.addAttribute("languageList",languageList);
        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        model.addAttribute("pageSizeList",pageSizeList);
        return new ModelAndView("create","email", new Email());
    }

    @PostMapping("/addEmail")
    public String addEmail(@ModelAttribute Email email, Model model){
        emailService.save(email);
        model.addAttribute("emailMap",emailService.findAll());
        return "emailList";
    }
}
