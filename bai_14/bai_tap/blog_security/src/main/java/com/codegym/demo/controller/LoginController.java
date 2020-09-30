package com.codegym.demo.controller;

import com.codegym.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User(); }


    @GetMapping("/")
    public String Index() {
        return "index";}


    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model) {
        if (user.getEmail().equals("admin@example.com") &&
                user.getPassword().equals("12345")) {
            model.addAttribute("message", "Login success. Welcome: ");
        } else {
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "index";
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
        SimpleDateFormat format1 = new SimpleDateFormat("yyy/MM/dd");

        String date =format.format(format1.parse("2020/12/12"));

        Date date2 = format.parse(date);
        Date date1 = format.parse("10/12/2020");
//        String time = format.format(date);
//        System.out.println(time);
        System.out.println(date2);
    }
}
