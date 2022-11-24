/*
package com.example.dday.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/*")
public class ManagerController {
    @GetMapping("/memberAll")
    public void memberAll(){}

    @GetMapping("/memberView")
    public void memberView(){}

}
*/
package com.example.dday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/*")
public class ManagerController {

    @GetMapping("/memberAll")
    public void memberAll() {
    }

    @GetMapping("/updateMemberStatus")
    public void updateMemberStatus() {
    }

    @GetMapping("/memberView")
    public void memberView() {
    }

}