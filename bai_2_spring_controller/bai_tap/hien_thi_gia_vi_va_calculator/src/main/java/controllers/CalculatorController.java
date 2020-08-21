package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @GetMapping
    public String home(){
        return "calculator";
    }
    @GetMapping("/result")
    public ModelAndView showResult(@RequestParam long value1, @RequestParam long value2, @RequestParam String cal){
        long result;
        switch (cal){
            case "Addition(+)":
                result = value1 + value2;
                break;
            case "Subtraction(-)":
                result = value1 - value2;
                break;
            case "Multiplication(*)":
                result = value1 * value2;
                break;
            case "Division(/)":
                if (value2 ==0 )
                    return (new ModelAndView("calculator"));
                result = value1 / value2;
                break;
            default:
                result =0;
        }
        ModelAndView modelAndView = new ModelAndView("calculator");
        modelAndView.addObject("calcu",cal);
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
