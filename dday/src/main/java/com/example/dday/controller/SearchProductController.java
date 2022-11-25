package com.example.dday.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search/*")
public class SearchProductController {
    @GetMapping("/search")
    public void search(){}

    @GetMapping("/searchNull")
    public void searchNull(){}
}
