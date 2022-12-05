package com.example.dday.controller;

import com.example.dday.domain.vo.CartDTO;
import com.example.dday.domain.vo.MemberDTO;
import com.example.dday.domain.vo.MemberVO;
import com.example.dday.domain.vo.OrderVO;
import com.example.dday.service.AddressService;
import com.example.dday.service.CartService;
import com.example.dday.service.MemberService;
import com.example.dday.service.PointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order/*")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final MemberService memberService;
    private final CartService cartService;
    private final AddressService addressService;
    private final PointService pointService;

    @GetMapping("/order")
    public void order(HttpSession session, Model model){
        Long memberNumber = ((MemberVO)session.getAttribute("member")).getMemberNumber();
        OrderVO orderVO = new OrderVO();
        MemberVO memberVO =  new MemberVO();
        MemberDTO memberDTO = new MemberDTO();

//        구매할 상품 정보
        List<CartDTO> cartDTOList = cartService.findAll(memberNumber);

        memberVO = memberService.findByNumber(memberNumber);
//        주문자 정보
        memberDTO.setMemberName(memberVO.getMemberName());
        memberDTO.setMemberPhoneNumber(memberVO.getMemberPhoneNumber());
        memberDTO.setMemberEmail(memberVO.getMemberEmail());
        memberDTO.setAddressVO(addressService.findByMemberNumber(memberNumber));

        model.addAttribute("cartList", cartDTOList);
        model.addAttribute("member", memberDTO);
        model.addAttribute("order", orderVO);
        model.addAttribute("point", pointService.findPointTotalByNumber(memberNumber));
    }

    @GetMapping("/orderComplete")
    public void orderComplete(){}


    @GetMapping("/recieverDetail")
    public void recieverDetail(){}
}
