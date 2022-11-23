package com.example.dday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {

    @GetMapping("/findId")
    public void findId(){}

    @GetMapping("/findPw")
    public void findPw(){}

    @GetMapping("/login")
    public void login(){}

    @GetMapping("/join")
    public void join(){}

    @GetMapping("/joinOk")
    public void joinOk(){}

    @GetMapping("/divide")
    public void divide(){}

//    mypage
    @GetMapping("/mypageCoupon")
    public void mypageCoupon(){}

    @GetMapping("/mypageDelivery")
    public void mypageDelivery(){}

    @GetMapping("/mypageEpi")
    public void mypageEpi(){}

    @GetMapping("/mypageEpiModify")
    public void mypageEpiModify(){}

    @GetMapping("/mypageLike")
    public void mypageLike(){}

    @GetMapping("/mypageOrderDetail")
    public void mypageOrderDetail(){}

    @GetMapping("/mypageSaving")
    public void mypageSaving(){}


}
