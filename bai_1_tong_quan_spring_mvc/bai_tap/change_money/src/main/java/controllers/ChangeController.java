package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class ChangeController {

    @GetMapping("/calculator")

    public String showList(@RequestParam int usd, @RequestParam int tiGia, Model model){
        int vnd = usd*tiGia;
        model.addAttribute("usd",usd);
        model.addAttribute("tiGia",tiGia);
        model.addAttribute("vnd", vnd);
        return "calculator";
    }
}
