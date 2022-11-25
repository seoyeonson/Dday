package com.example.dday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/product/*")
public class ProductController {
    @GetMapping("/newCategory")
    public void newCategory(){}

    @GetMapping("/bestCategory")
    public void bestCategory(){}

    @GetMapping("/saleCategory")
    public void saleCategory(){}

    @GetMapping("/todayCategory")
    public void todayCategory(){}

    @GetMapping("/categoryDetail")
    public void categoryDetail(){}
}
