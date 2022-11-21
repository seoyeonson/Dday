package com.example.dday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/manager/*")
public class ManagerController {

    @GetMapping("/bannerUpdate")
    public void bannerUpdate(){}

    @GetMapping("/bannerView")
    public void bannerView(){}

    @GetMapping("/bannerWrite")
    public void bannerWrite(){}

    @GetMapping("/managerBanner")
    public void managerBanner(){}

    @GetMapping("/managerFAQ")
    public void managerFAQ(){}

    @GetMapping("/managerNotice")
    public void managerNotice(){}

    @GetMapping("/memberAll")
    public void memberAll(){}

    @GetMapping("/mamberView")
    public void mamberView(){}

    @GetMapping("/noticeUpdate")
    public void noticeUpdate(){}

    @GetMapping("/noticeWrite")
    public void noticeWrite(){}
}
