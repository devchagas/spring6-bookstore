package com.devchagas.spring6bookstore.controllers;

import com.devchagas.spring6bookstore.services.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @RequestMapping("/publishers")
    private String getBook(Model model) {
        model.addAttribute("publishers", publisherService.findAll());
        return "publishers";
    }
}

