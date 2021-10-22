package com.example.springsecurity.controller;


import com.example.springsecurity.entity.Operation;
import com.example.springsecurity.entity.User;
import com.example.springsecurity.service.OperationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/calc")
public class CalculatorController {

    private final OperationService operationService;
    private final List<String> stringList;

    public CalculatorController(OperationService operationService) {
        this.operationService = operationService;
        this.stringList = operationService.getOperationManager().getNameOperations();
    }

    @GetMapping("/count")
    public String calc(@ModelAttribute("newOperation") Operation operation, Model model) {
        model.addAttribute("listOperations", operationService.getOperationManager().getNameOperations());
        return "calc";
    }


    @PostMapping("/count")
    public String calc( Model model, @ModelAttribute("newOperation") Operation operation) {
        Optional<Operation> operation1 = operationService.add(operation);
        if(operation1.isPresent()) {
            model.addAttribute("listOperations", stringList);
            model.addAttribute("result", operation1.get().getResult());
        }else model.addAttribute("message","Error in count");
        return "calc";
    }
}
