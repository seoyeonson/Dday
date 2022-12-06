package com.example.dday.controller;

import com.example.dday.domain.vo.*;
import com.example.dday.service.AddressService;
import com.example.dday.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cart/*")
@RequiredArgsConstructor
@Slf4j
public class CartController {
    private final CartService cartService;
    private final AddressService addressService;

//    장바구니 목록
    @GetMapping("/list")
    public void list(HttpSession session, Model model){
        Long memberNumber = ((MemberVO)session.getAttribute("member")).getMemberNumber();
        model.addAttribute("address", Optional.ofNullable(addressService.findByMemberNumber(memberNumber)).orElse(new AddressVO()));
    }

    @GetMapping("/all")
    @ResponseBody
    public CartListDTO all(HttpSession session){
        Long memberNumber = ((MemberVO)session.getAttribute("member")).getMemberNumber();
        return new CartListDTO(cartService.findAll(memberNumber), cartService.getTotal(memberNumber));
    }

    @PostMapping("/modify")
    @ResponseBody
    public void modify(HttpSession session, @RequestBody CartUpdateDTO cartUpdateDTO){
        Long memberNumber = ((MemberVO)session.getAttribute("member")).getMemberNumber();
        CartVO cartVO = new CartVO();

        cartVO.setMemberNumber(memberNumber);
        cartVO.setProductNumber(cartUpdateDTO.getProductNumber());

        if(cartUpdateDTO.getCalcType().equals("plus")){
            cartVO.setCartCount(cartUpdateDTO.getCartCount()+1);
        }else if(cartUpdateDTO.getCalcType().equals("minus")){
            cartVO.setCartCount(cartUpdateDTO.getCartCount()-1);
        }

        log.info("상품 수량" + cartVO.getCartCount());

        cartService.modify(cartVO);
    }

    @DeleteMapping("/{productNumber}")
    @ResponseBody
    public void delete(HttpSession session, @PathVariable Long productNumber){
        CartVO cartVO = new CartVO();
        Long memberNumber = ((MemberVO)session.getAttribute("member")).getMemberNumber();
        cartVO.setMemberNumber(memberNumber);
        cartVO.setProductNumber(productNumber);
        cartService.remove(cartVO);
    }

    @PostMapping
    @ResponseBody
    public void remove(HttpSession session, @RequestBody Long productNumber){
        MemberVO memberVO = ((MemberVO)session.getAttribute("member"));
        addressService.remove(memberVO.getMemberNumber());
    }


    @GetMapping("/cartEmpty")
    public void cartEmpty(){}

    // 카트 담기
    @ResponseBody
    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    public void addCart(CartVO cartVO, HttpSession session){

        MemberVO memberVO = ((MemberVO)session.getAttribute("member"));
        cartVO.setMemberNumber((memberVO.getMemberNumber()));

        cartService.getEachCount(cartVO);
        cartVO.setCartCount(cartService.getEachCount(cartVO)+cartVO.getCartCount());
        cartService.save(cartVO);

    }

}
