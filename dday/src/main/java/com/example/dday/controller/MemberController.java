package com.example.dday.controller;

import com.example.dday.domain.vo.MemberDTO;
import com.example.dday.domain.vo.MemberVO;
import com.example.dday.service.AddressService;
import com.example.dday.service.MemberService;
import com.example.dday.service.OrderService;
import com.example.dday.service.PointService;
import com.example.dday.type.MemberType;
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
import java.lang.reflect.Member;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final PointService pointService;
    private final AddressService addressService;
    private final OrderService orderService;

//    Session으로 memberNumber, pointTotal, likeTotal Check는 AOP 를 이용하여 체크할 수 있도록 추후 수정
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
    public RedirectView join(MemberDTO member, HttpSession session){
        log.info("member: " + member);
        String url = "";
        memberService.join(member);
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberNumber(member.getMemberNumber());
        memberVO.setMemberName(member.getMemberName());
        memberVO.setMemberType(member.getMemberType());
        session.setAttribute("member", memberVO);

        if(member.getMemberType().equals(MemberType.NORMAL.label())){
            url ="/member/joinNormalOk";
        }else if (member.getMemberType().equals(MemberType.PARTNER.label())){
            url = "/member/joinPartnerOk";
        }

        return new RedirectView(url);
    }

    @GetMapping("/joinNormalOk")
    public void joinNormalOk(){;}

    @GetMapping("/joinPartnerOk")
    public void joinPartnerOk(){;}

    @GetMapping("/login")
    public void login(Model model){ model.addAttribute("member", new MemberVO()); }

    @PostMapping("/login")
    @ResponseBody
    public MemberVO login(MemberVO memberVO, HttpSession session){
        memberVO = memberService.login(memberVO);
        log.info("memberVO: " + memberVO);
        if(memberVO.getMemberNumber() != null){
            session.setAttribute("member", memberVO);
        }
        return memberVO;
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/");
    }

//    mypage
    @GetMapping("/mypage")
    public void mypage(HttpSession session, Model model){
        MemberVO memberVO = (MemberVO)session.getAttribute("member");
        Long pointTotal = pointService.findPointTotalByNumber(memberVO.getMemberNumber());
        Long likeTotal = memberService.findLikeTotalByNumber(memberVO.getMemberNumber());
        model.addAttribute("orders", orderService.findByMemberNumber(memberVO.getMemberNumber()));

        session.setAttribute("pointTotal", pointTotal);
        session.setAttribute("likeTotal", likeTotal);
    }

    @GetMapping("/mypageCoupon")
    public void mypageCoupon(){}

    @GetMapping("/mypageDelivery")
    public void mypageDelivery(HttpSession session, Model model){
        Long memberNumber = ((MemberVO)session.getAttribute("member")).getMemberNumber();
        Long pointTotal = pointService.findPointTotalByNumber(memberNumber);
        Long likeTotal = memberService.findLikeTotalByNumber(memberNumber);

        session.setAttribute("pointTotal", pointTotal);
        session.setAttribute("likeTotal", likeTotal);
        model.addAttribute("addresses", addressService.findAll(memberNumber));
    }

    @GetMapping("/mypageEpi")
    public void mypageEpi(HttpSession session, Model model){
        MemberVO memberVO = memberService.findByNumber(((MemberVO)session.getAttribute("member")).getMemberNumber());
        model.addAttribute("member", memberVO);
    }

    @GetMapping("/mypageEpiModify")
    public void mypageEpiModify(MemberVO member, HttpSession session, Model model){
        MemberVO memberVO = memberService.findByNumber(((MemberVO)session.getAttribute("member")).getMemberNumber());
        model.addAttribute("member", memberVO);
    }

    @PostMapping("/mypageEpiModify")
    public RedirectView mypageEpiModify(MemberVO member, HttpSession session){
        member.setMemberNumber(((MemberVO)session.getAttribute("member")).getMemberNumber());
        memberService.modify(member);
        return new RedirectView("/member/mypage");
    }

    @GetMapping("/mypageLike")
    public void mypageLike(HttpSession session){
        MemberVO memberVO = (MemberVO)session.getAttribute("member");
        Long pointTotal = pointService.findPointTotalByNumber(memberVO.getMemberNumber());
        Long likeTotal = memberService.findLikeTotalByNumber(memberVO.getMemberNumber());

        session.setAttribute("pointTotal", pointTotal);
        session.setAttribute("likeTotal", likeTotal);
    }

    @GetMapping("/checkId/{memberId}")
    @ResponseBody
    public int checkId(@PathVariable String memberId){
        return memberService.checkId(memberId);
    }

    @GetMapping("/checkEmail/{memberEmail}")
    @ResponseBody
    public int checkEmail(@PathVariable String memberEmail){
        return memberService.checkEmail(memberEmail);
    }

    @GetMapping("/mypageOrderDetail")
    public void mypageOrderDetail(){}

    @GetMapping("/mypageSaving")
    public void mypageSaving(HttpSession session, Model model){
        model.addAttribute("points", pointService.showAll(((MemberVO)session.getAttribute("member")).getMemberNumber()));
    }

    @GetMapping("/mypageReview")
    public void mypageReview(){}


}
