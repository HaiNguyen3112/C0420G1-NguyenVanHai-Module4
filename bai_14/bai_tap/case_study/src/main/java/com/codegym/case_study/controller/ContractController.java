package com.codegym.case_study.controller;


import com.codegym.case_study.model.Contract;
import com.codegym.case_study.model.ContractDetail;
import com.codegym.case_study.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("contract")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class ContractController {
    @Autowired
    ContractService contractService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ServiceService serviceService;
    @Autowired
    AttachServiceService attachService;
    @Autowired
    ContractDetailService contractDetailService;


    @ModelAttribute("contract")
    public Contract setUpContractForm()
    {
        return new Contract();
    }


    @GetMapping("/contract")
    public String showList(@RequestParam(name = "codeContract",defaultValue = "")String search, Model model){
        List<Contract> contractList = contractService.findAllByCodeContractContainingAndStatusTrue(search);
        if (contractList.isEmpty())
            model.addAttribute("message","Contract List Empty");
        model.addAttribute("contractList",contractList);

        return "contract/list";
    }

    @PostMapping("/contract/search")
    public String getSearch(@RequestParam(name = "codeContract",defaultValue = "")String search, Model model){
        List<Contract> contractList = contractService.findAllByCodeContractContainingAndStatusTrue(search);
        if (contractList.isEmpty())
            model.addAttribute("message","Contract List Empty");
        model.addAttribute("contractList",contractList);

        return "contract/list";
    }

    @GetMapping("/contract/view/{id}")
    public String view(@PathVariable Long id, Model model, RedirectAttributes redirect){
        Contract contract = contractService.findById(id);
        List<ContractDetail> contractDetailList = contractDetailService.findAllByContract(contract);
        if (contract != null){
            model.addAttribute("contractDetailList",contractDetailList);
            model.addAttribute("contract", contract);
            return "contract/view";
        } else {
            redirect.addFlashAttribute("message","Not found or Contract you choose not exist!!!");
            return "redirect:/contract";
        }
    }

    @GetMapping("/contract/create")
    public String createForm(Model model){
        model.addAttribute("contract", new Contract());
        model.addAttribute("employeeList",employeeService.findAll());
        model.addAttribute("customerList",customerService.findAll());
        model.addAttribute("serviceList",serviceService.findAll());
        return "contract/create";
    }

    @PostMapping("/contract/create")
    public String create( @Valid @ModelAttribute Contract contract, BindingResult bindingResult, Model model){
        new Contract().validate(contract,bindingResult);
        if (!bindingResult.hasFieldErrors()) {
            try {
                contractService.save(contract);
                model.addAttribute("message","Successful");
                model.addAttribute("contract", new Contract());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                model.addAttribute("messageCode", "Code is exist!!!");
                model.addAttribute("employeeList", employeeService.findAll());
                model.addAttribute("customerList", customerService.findAll());
                model.addAttribute("serviceList", serviceService.findAll());
                return "contract/create";
            }

        }

        model.addAttribute("employeeList",employeeService.findAll());
        model.addAttribute("customerList",customerService.findAll());
        model.addAttribute("serviceList",serviceService.findAll());

        return "contract/create";

    }

    @GetMapping("/contract/edit/{id}")
    public String editForm(@PathVariable Long id, Model model, RedirectAttributes redirect){
        Contract contract = contractService.findById(id);
        model.addAttribute("employeeList",employeeService.findAll());
        model.addAttribute("customerList",customerService.findAll());
        model.addAttribute("serviceList",serviceService.findAll());
        model.addAttribute("attachServiceList",attachService.findAll());
        if (contract != null){
            model.addAttribute("contract", contract);
            return "contract/edit";
        } else {
            redirect.addFlashAttribute("message","Not found or Contract you choose not exist!!!");
            return "redirect:/contract";
        }

    }

    @PostMapping("/contract/edit")
    public String edit(@ModelAttribute Contract contract){
        contractService.save(contract);
        return "redirect:/contract";
    }

//    @GetMapping("/contract/delete/{id}")
//    public String delete(@PathVariable Long id, HttpServletResponse  response){
//
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
//        Date date = new Date();
//        String time = format.format(date);
//
//
//
//        String name = contractService.findById(id).getCodeContract();
//        Cookie cookie = new Cookie(name, time);
//        cookie.setMaxAge(5*60);
//        cookie.setPath("/"); // global cookie accessible every where
//        // cookie.setPath("/contract");  global cookie accessible only in /contract/*
//        response.addCookie(cookie);
//
//        Contract contract = contractService.findById(id);
//        contract.setStatus(false);
//        contractService.save(contract);
////        contractService.deleteById(id);
//        return "redirect:/contract";
//    }

    @PostMapping("/contract/delete/")
    public String delete(@RequestParam("id") Long id, HttpServletResponse  response){

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
        Date date = new Date();
        String time = format.format(date);



        String name = contractService.findById(id).getCodeContract();
        Cookie cookie = new Cookie(name, time);
        cookie.setMaxAge(5*60);
        cookie.setPath("/"); // global cookie accessible every where
        // cookie.setPath("/contract");  global cookie accessible only in /contract/*
        response.addCookie(cookie);

        Contract contract = contractService.findById(id);
        contract.setStatus(false);
        contractService.save(contract);
//        contractService.deleteById(id);
        return "redirect:/contract";
    }

    // Got contract deleted
    @GetMapping("/contract/deleteContractList")
    public String getList(HttpServletRequest request,
                          @RequestParam(name = "codeContract",defaultValue = "")String search, Model model){

        Cookie[] cookies = request.getCookies();
        List<Contract> tempList = contractService.findAllByCodeContractContainingAndStatusFalse("");
        Map<Contract,String> contractListDeleted = new HashMap<>();
        for (Cookie cookie : cookies){
            for (Contract contract : tempList){
                if (cookie.getName().equals(contract.getCodeContract())){
                    contractListDeleted.put(contract,cookie.getValue());
                    break;
                }
            }
        }

        if (contractListDeleted.isEmpty()){
            model.addAttribute("messageDelete","List Delete is Empty");
        } else {
            model.addAttribute("contractDeleteList",contractListDeleted);
        }
        List<Contract> contractList = contractService.findAllByCodeContractContainingAndStatusTrue(search);
        if (contractList.isEmpty())
            model.addAttribute("message","Contract List Empty");
        model.addAttribute("contractList",contractList);

        return "contract/list";
    }










    //Contract Detail


    @GetMapping("/contractdetail/create/{id}")
    public String createContractDetailForm(@PathVariable Long id, Model model){
        model.addAttribute("contract", contractService.findById(id));
        model.addAttribute("attachServiceList",attachService.findAll());
        model.addAttribute("contractDetail",new ContractDetail());
        return "contractdetail/create";
    }

    @PostMapping("/contractdetail/create")
    public String createContractDetail(@ModelAttribute ContractDetail contractDetail, Model model){
        contractDetailService.save(contractDetail);
        model.addAttribute("message","Successful");
        return "redirect:/contract";
    }

}

