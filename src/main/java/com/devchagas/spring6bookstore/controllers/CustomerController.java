package com.devchagas.spring6bookstore.controllers;

import com.devchagas.spring6bookstore.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    private String getCustomers(Model model){
        model.addAttribute("customers", customerService.findAll());
        return "customers";
    }
}
