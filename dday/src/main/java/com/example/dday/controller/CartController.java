package com.example.dday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/cart/*")
public class CartController {
//    장바구니 목록
    @GetMapping("/list")
    public void list(){}

    @GetMapping("/cartEmpty")
    public void cartEmpty(){}

}
