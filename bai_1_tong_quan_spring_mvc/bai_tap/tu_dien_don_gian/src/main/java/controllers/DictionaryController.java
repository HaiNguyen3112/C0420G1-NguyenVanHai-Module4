package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    @GetMapping("/show")
    public String show(){
        return "show";
    }
    @GetMapping("/search")
    public static  String showResult(@RequestParam String word, Model model){
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("read","đọc");
        hashMap.put("book","sách");
        hashMap.put("run","chạy");
        hashMap.put("sleep","ngủ");

        if (hashMap.get(word) == null){
            word = "Not found";
        } else word = hashMap.get(word);
        model.addAttribute("result",word);
        return "search";
    }
}
