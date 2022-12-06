package com.example.dday.controller;

import com.example.dday.domain.vo.*;
import com.example.dday.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order/*")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final MemberService memberService;
    private final CartService cartService;
    private final AddressService addressService;
    private final PointService pointService;
    private final OrderService orderService;
    private final OrderDetailService orderDetailService;

    @GetMapping("/order")
    public void order(HttpSession session, Model model){
        Long memberNumber = ((MemberVO)session.getAttribute("member")).getMemberNumber();
        OrderVO orderVO = new OrderVO();
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        MemberVO memberVO;
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
        model.addAttribute("orderDetail", orderDetailVO);
        model.addAttribute("point", pointService.findPointTotalByNumber(memberNumber));
    }

    @PostMapping("/order")
    @Transactional(rollbackFor = Exception.class)
    public RedirectView order(HttpSession session, OrderVO orderVO){
        OrderDTO orderDTO = new OrderDTO();
        if(Optional.ofNullable(((MemberVO)session.getAttribute("member")).getMemberNumber()).orElse(0L) == 0){
            return new RedirectView("/");
        }
        Long memberNumber = ((MemberVO)session.getAttribute("member")).getMemberNumber();
        orderVO.setMemberNumber(memberNumber);
        log.info("orderVO: " + orderVO);
        log.info("orderDetailVO: " + cartService.findAll(memberNumber));

        orderService.save(orderVO);

        List<CartDTO> cartDTO = cartService.findAll(memberNumber);
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        cartDTO.forEach(cart->{
            orderDetailVO.setOrderDetailCount(cart.getCartCount());
            orderDetailVO.setOrderNumber(orderVO.getOrderNumber());
            orderDetailVO.setOrderDetailPrice(cart.getProductSalePrice());
            orderDetailVO.setProductNumber(cart.getProductNumber());
            orderDetailVO.setOrderDetailTotalAmount(cart.getCartCount() * cart.getProductSalePrice());
            orderDetailService.save(orderDetailVO);
        });
        return new RedirectView("/member/mypage");
    }

    @GetMapping("/orderComplete")
    public void orderComplete(){}


    @GetMapping("/recieverDetail")
    public void recieverDetail(){}
}
