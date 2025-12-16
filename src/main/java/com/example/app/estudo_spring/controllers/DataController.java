package com.example.app.estudo_spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.estudo_spring.services.AllDatasService;

@RestController
@RequestMapping("/")
public class DataController {
    @Autowired
    private AllDatasService allDatasService;


    @GetMapping
    public String index() {
        return allDatasService.index();
    }

}
