package com.example.dday.controller;

import com.example.dday.domain.vo.MemberDTO;
import com.example.dday.domain.vo.MemberVO;
import com.example.dday.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/divide")
    public void divide(Model model){
        model.addAttribute("member", new MemberVO());
    }

//    @PostMapping("/divide")
//    public String divide(Model model){
//        model.addAttribute("member", new MemberDTO());
//        return "/member/join";
//    }

    @GetMapping("/join")
    public void join(@RequestParam MemberVO member, Model model){
        log.info("memberType: " + member.getMemberType());
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberType( member.getMemberType());
        model.addAttribute("member", new MemberDTO());
    }

    @PostMapping("/join")
    public RedirectView join(MemberDTO memberDTO, RedirectAttributes redirectAttributes){
        memberService.join(memberDTO);
        redirectAttributes.addFlashAttribute("memberType", memberDTO.getMemberType());
        redirectAttributes.addFlashAttribute("memberNumber", memberDTO.getMemberNumber());
        return new RedirectView("/member/joinOk");
    }

    @GetMapping("/joinOk")
    public void joinOk(){;}

    @GetMapping("/login")
    public void login(Model model){ model.addAttribute("member", new MemberVO()); }

    @PostMapping("/login")
    @ResponseBody
    public Long login(MemberVO memberVO){
        return memberService.login(memberVO);
    }

//    mypage
    @GetMapping("/mypage")
    public void mypage(){}

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

    @GetMapping("/mypageReview")
    public void mypageReview(){}


}
