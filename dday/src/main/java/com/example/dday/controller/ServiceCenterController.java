package com.example.dday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/serviceCenter/*")
public class ServiceCenterController {
    @GetMapping("/noticeBoardListDetail")
    public void noticeBoardListDetail(){}

    @GetMapping("/questionForm")
    public void questionForm(){}

    @GetMapping("/serviceFAQ")
    public void serviceFAQ(){}

    @GetMapping("/serviceNotice")
    public void serviceNotice(){}

    @GetMapping("/serviceQuestion")
    public void serviceQuestion(){}

}
