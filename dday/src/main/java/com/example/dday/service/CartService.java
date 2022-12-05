package com.example.dday.service;

import com.example.dday.domain.vo.CartDTO;
import com.example.dday.domain.vo.CartVO;
import com.example.dday.repository.CartDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartDAO cartDAO;
    //    장바구니 목록
    public List<CartDTO> findAll(Long memberNumber){ return cartDAO.findAll(memberNumber); };
    //    장바구니 상품 삭제
    public void remove(CartVO cartVO){ cartDAO.remove(cartVO); };
    //    장바구니 상품 개수 수정
    public void modify(CartVO cartVO){ cartDAO.setCount(cartVO); };
    //    장바구니 상품 추가
    public void save(CartVO cartVO){
        Integer cartCount = Optional.ofNullable(cartDAO.checkCart(cartVO)).orElse(0);
        if(cartCount == 0){
            cartDAO.save(cartVO);
        } else {
            cartDAO.setCount(cartVO);
        }
    };
    //    장바구니 상품 총 개수
    public Integer getTotal(Long memberNumber){ return cartDAO.getTotal(memberNumber); };
}
