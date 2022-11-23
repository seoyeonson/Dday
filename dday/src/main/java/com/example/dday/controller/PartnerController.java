package com.example.dday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/partner/*")
public class PartnerController {
    @GetMapping("/deliveryStatusForm")
    public void deliveryStatusForm(){}

    @GetMapping("/partner_change_info")
    public void partner_change_info(){}

    @GetMapping("/partner_main")
    public void partner_main(){}

    @GetMapping("/partner_management")
    public void partner_management(){}

    @GetMapping("/partner_registration")
    public void partner_registration(){}

    @GetMapping("/partner_shipping")
    public void partner_shipping(){}

    @GetMapping("/partnerProductChange")
    public void partnerProductChange(){}
}
