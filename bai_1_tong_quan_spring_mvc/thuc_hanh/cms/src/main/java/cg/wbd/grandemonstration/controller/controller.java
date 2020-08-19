package cg.wbd.grandemonstration.controller;

import org.springframework.stereotype.Controller;


@Controller
public class CustomerController {
    @GetMapping("/customers")
    public String showList() {
        return "customers/list.jsp";
    }
}
