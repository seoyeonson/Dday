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

import com.example.dday.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/manager/*")
public class ManagerController {

    // 이 코드가 있어야 밑에서 managerService를 인식해서 Service의 메소드를 쓸 수 있다.
    private final ManagerService managerService;

    //회원 목록
    @GetMapping("/memberAll")
    public void memberAll(Model model) {
       model.addAttribute("memberInfo", managerService.showAll());
    }

    //탈퇴회원페이지
    @GetMapping("/updateMemberStatus")
    public void updateMemberStatus() {
    }

    //멤버상세페이지
    @GetMapping("/memberView")
    public void memberView() {
    }

}