package com.codegym.case_study_md4.controller;


import com.codegym.case_study_md4.model.Contract;
import com.codegym.case_study_md4.model.ContractDetail;
import com.codegym.case_study_md4.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
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



    @GetMapping("/contract")
    public String showList( Model model){
        List<Contract> contractList = contractService.findAll();
        if (contractList.isEmpty())
            model.addAttribute("message","Contract List Empty");
        model.addAttribute("contractList",contractList);

        return "contract/list";
    }

    @PostMapping("/contract/search")
    public String getSearch(@RequestParam(name = "codeContract",defaultValue = "")String search, Model model){
        List<Contract> contractList = contractService.findAllByCodeContractContaining(search);
        if (contractList.isEmpty())
            model.addAttribute("message","Contract List Empty");
        model.addAttribute("contractList",contractList);

        return "contract/list";
    }

    @GetMapping("/contract/view/{id}")
    public String view(@PathVariable Long id, Model model, RedirectAttributes redirect){
        Contract contract = contractService.findById(id);
        if (contract != null){
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
    public String create(@ModelAttribute Contract contract, Model model){
        contractService.save(contract);
        model.addAttribute("contract", new Contract());
        model.addAttribute("employeeList",employeeService.findAll());
        model.addAttribute("customerList",customerService.findAll());
        model.addAttribute("serviceList",serviceService.findAll());
        model.addAttribute("message","Successful");
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

    @GetMapping("/contract/delete/{id}")
    public String delete(@PathVariable Long id){
        contractService.deleteById(id);
        return "redirect:/contract";
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
