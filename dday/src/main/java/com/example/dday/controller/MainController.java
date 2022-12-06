package com.example.dday.controller;

import com.example.dday.domain.vo.MemberVO;
import com.example.dday.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Member;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
@Slf4j
public class MainController {

    private final MainService mainService;

    @GetMapping("/")
    public String main(Model model, HttpSession session){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberNumber(0L);
        session.setAttribute("member", Optional.ofNullable((MemberVO)session.getAttribute("member")).orElse(memberVO));
        model.addAttribute("mainProduct", mainService.showMainProduct());
        model.addAttribute("mainProduct2", mainService.showMainProduct2());
        model.addAttribute("mainProduct3", mainService.showMainProduct3());
        model.addAttribute("mainProduct4", mainService.showMainProduct4());
        model.addAttribute("mainProduct5", mainService.showMainProduct5());
        model.addAttribute("mainProduct5", mainService.showMainProduct6());

        return "index";
   }

//   @GetMapping("/")
//    public void selectAll(Model model) {
//        log.info("메인들어옴");
//        model.addAttribute("mainProduct", mainService.showMainProduct());
//   }


}





















