package com.example.dday.service;

import com.example.dday.domain.vo.AddressVO;
import com.example.dday.domain.vo.CartVO;
import com.example.dday.domain.vo.MemberDTO;
import com.example.dday.type.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CartServiceTest {

    @Autowired
    private CartService cartService;

    @Test
    public void findAllTest(){
        cartService.findAll(26L);
    }

    @Test
    public void removeTest(){
        CartVO cartVO = new CartVO();
        cartVO.setMemberNumber(26L);
        cartVO.setProductNumber(1L);
        cartService.remove(cartVO);
    }

    @Test
    public void setCount(){
        CartVO cartVO = new CartVO();
        cartVO.setCartCount(5);
        cartVO.setMemberNumber(26L);
        cartVO.setProductNumber(1L);
        cartService.modify(cartVO);
    }

    @Test
    public void save(){
        CartVO cartVO = new CartVO();
        cartVO.setCartCount(2);
        cartVO.setMemberNumber(26L);
        cartVO.setProductNumber(3L);
        cartService.save(cartVO);
    }

}