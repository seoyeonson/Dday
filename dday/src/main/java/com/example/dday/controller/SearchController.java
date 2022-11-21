package com.example.dday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search/*")
public class SearchController {
    @GetMapping("/search")
    public void search(){}

    @GetMapping("/searchNull")
    public void searchNull(){}
}
