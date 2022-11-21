package com.example.dday.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myPage/*")
public class MypageController {

    @GetMapping("/myPage")
    public void myPage(){}

    @GetMapping("/myPageCoupon")
    public void myPageCoupon(){}

    @GetMapping("/myPageDelivery")
    public void myPageDelivery(){}

    @GetMapping("/myPageEpi")
    public void myPageEpi(){}

    @GetMapping("/myPageEpiModify")
    public void myPageEpiModify(){}

    @GetMapping("/myPageLike")
    public void myPageLike(){}

    @GetMapping("/myPageOrderDetail")
    public void myPageOrderDetail(){}

    @GetMapping("/myPageSaving")
    public void myPageSaving(){}
}
