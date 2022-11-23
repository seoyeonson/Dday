package com.example.dday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order/*")
public class OrderController {
    @GetMapping("/orderComplete")
    public void orderComplete(){}

    @GetMapping("/order")
    public void order(){}

    @GetMapping("/recieverDetail")
    public void recieverDetail(){}
}
