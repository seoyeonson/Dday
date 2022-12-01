package com.example.dday.controller;

import com.example.dday.domain.vo.MemberDTO;
import com.example.dday.domain.vo.MemberVO;
import com.example.dday.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/divide")
    public void divide(){;}

    @GetMapping("/join")
    public void join(String memberType, Model model){
        log.info("memberType Get join: " + memberType);
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberType(memberType);
        model.addAttribute("member", memberDTO);
    }

    @PostMapping("/join")
    public String join(MemberDTO member, HttpSession session){
        log.info("member: " + member);
        log.info("MemberType Posy join: " + member.getMemberType());
        String url = "";

        memberService.join(member);

        session.setAttribute("member", member);

        if(member.getMemberType().equals("normal")){
            url ="/member/joinNormalOk";
        }else if (member.getMemberType().equals("partner")){
            url = "/member/joinPartnerOk";
        }

        return url;
    }

    @GetMapping("/joinNormalOk")
    public void joinNormalOk(){;}

    @GetMapping("/joinPartnerOk")
    public void joinPartnerOk(){;}

    @GetMapping("/login")
    public void login(Model model){ model.addAttribute("member", new MemberVO()); }

    @PostMapping("/login")
    @ResponseBody
    public Long login(@ModelAttribute("member") MemberVO memberVO, HttpSession session){
        log.info("member: " + memberVO);
        if(memberService.login(memberVO) != 0){
            memberVO = memberService.findByNumber(memberService.login(memberVO));
        } else {
            memberVO = null;
        }
        session.setAttribute("member", memberVO);
        return memberService.login(memberVO);
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/");
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
