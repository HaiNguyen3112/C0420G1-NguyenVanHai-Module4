package com.codegym.exam_nguyenvanhai_md4.Controller;

import com.codegym.exam_nguyenvanhai_md4.Service.DiscountService;
import com.codegym.exam_nguyenvanhai_md4.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @GetMapping("/")
    public String getList(Model model){
        List<Discount> discountList = discountService.findAll();
        if (discountList.isEmpty()){
            model.addAttribute("message","List Empty");
        }
        model.addAttribute("discountList", discountList);
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("discount", new Discount());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Discount discount, BindingResult bindingResult, Model model){

        new Discount().validate(discount,bindingResult);
        if (!bindingResult.hasFieldErrors()){
            discountService.save(discount);
            model.addAttribute("discount", new Discount());
        }

        return "create";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){
        Discount discount = discountService.findById(id);
        model.addAttribute("discount", discount);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute Discount discount, BindingResult bindingResult, RedirectAttributes redirect){
        new Discount().validate(discount,bindingResult);
        if (!bindingResult.hasFieldErrors()){
            discountService.save(discount);
            return "redirect:/";
        }
        redirect.addFlashAttribute("message","Can't Complete cause wrong input!");
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id){
        discountService.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/discount/search")
    public String search(@RequestParam(value = "number") String number, Model model, RedirectAttributes redirect){
      try{
         int tempNumber = Integer.parseInt(number);
          List<Discount> discountList = discountService.findAllByNumber(tempNumber);
          if (discountList.isEmpty()){
              model.addAttribute("message","Not found ");
              model.addAttribute("discountList", discountService.findAll());
          }
          model.addAttribute("discountList", discountList);
        return "list";
      } catch (Exception e){
          System.out.println(e.getMessage());
          redirect.addFlashAttribute("message","Value must be a number!!!");
      }
        return "redirect:/";
    }
}
