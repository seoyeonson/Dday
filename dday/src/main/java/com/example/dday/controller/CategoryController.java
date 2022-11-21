package com.example.dday.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category/*")
class CategoryController {

    @GetMapping("/category")
    public void category(){}

    @GetMapping("/categoryDetail")
    public void categoryDetail(){}
}
