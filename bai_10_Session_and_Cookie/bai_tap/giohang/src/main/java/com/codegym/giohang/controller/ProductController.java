package com.codegym.giohang.controller;

import com.codegym.giohang.model.Product;
import com.codegym.giohang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("product")
public class ProductController {
    @Autowired
    ProductService productService;


    @ModelAttribute("product")
    public Product setUpProductForm(){
        return new Product();
    }


    @GetMapping("/product")
    public String show(@PageableDefault(value = 5)Pageable pageable, @RequestParam(name = "name",defaultValue = "") String name, Model model){
        if (productService.findAllByNameContaining(name,pageable).isEmpty()){
            model.addAttribute("message","Hiện chưa có sản phẩm nào!!!");
        }
        model.addAttribute("productList",productService.findAllByNameContaining(name,pageable));
        return "list";
    }
    @GetMapping("/product/view/{id}")
    public String viewProduct(@PathVariable Long id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        //neu chon 2 lan.
        return "view";
    }
    @PostMapping("/product/view")
    public String buyProduct(@ModelAttribute("product") Product product ,HttpServletResponse response,HttpServletRequest request){

            boolean check = false;
            String tempName = product.getCode();
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies){
                if (cookie.getName().equals(tempName)){
                    int temp = Integer.parseInt(cookie.getValue());
                    temp ++;
                    cookie = new Cookie(cookie.getName(),String.valueOf(temp));
                    cookie.setMaxAge(5*60);
                    response.addCookie(cookie);
                    check = true;
                    break;
                }
            }
            if (!check){
                Cookie cookie = new Cookie(tempName,"1");
                cookie.setMaxAge(5*60);
                response.addCookie(cookie);
            }

            return "redirect:/product";
    }

    @GetMapping("/product/delete{cookieName}")
    public String deleteCookie(@PathVariable String cookieName, HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equals(cookieName)){
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
        return "redirect:/product/pay";
    }



    @GetMapping("/product/pay")
    public String viewPay( HttpServletRequest request, Model model){
        List<Product> products = productService.fillAll();
        Map<Product,Integer> productList = new HashMap<>();

        Cookie[] cookies = request.getCookies();

                    try {
                for (Cookie cookie : cookies) {
                  for (Product product : products){
                      if (product.getCode().equals(cookie.getName())){
                          productList.put(product,Integer.parseInt(cookie.getValue()));
                         break;
                      }
                  }

                }
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
            finally {
                if (productList.isEmpty()){
                    model.addAttribute("message","Bạn chưa chọn sản phẩm nào!!!");
                }
            }
        model.addAttribute("products", productList);
         int total =0;
         for (Product product : productList.keySet()){
             total += product.getPrice()*productList.get(product);
         }
         model.addAttribute("total",total);
        return "pay";
    }
}
