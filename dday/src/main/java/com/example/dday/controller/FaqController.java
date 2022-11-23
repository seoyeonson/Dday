package com.example.dday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faq/*")
public class FaqController {
//    FAQ 목록
    @GetMapping("/list")
    public void list() {

    }
}
