package com.example.dday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/cart/*")
public class CartController {

    @GetMapping("/cart")
    public void cart(){}

    @GetMapping("/cartEmpty")
    public void cartEmpty(){}

    @GetMapping("/orderComplete")
    public void cartorderCompleteEmpty(){}

    @GetMapping("/order")
    public void order(){}

    @GetMapping("/recieverDetail")
    public void cartErecieverDetailmpty(){}

}
