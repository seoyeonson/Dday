package com.example.dday.repository;

import com.example.dday.domain.vo.CartDTO;
import com.example.dday.domain.vo.CartVO;
import com.example.dday.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CartDAO {
    private final CartMapper cartMapper;

    //    장바구니 목록
    public List<CartDTO> findAll(Long memberNumber){ return cartMapper.selectAll(memberNumber); };
    //    장바구니 상품 삭제
    public void remove(CartVO cartVO){ cartMapper.delete(cartVO); };
    //    장바구니 상품 개수 수정
    public void setCount(CartVO cartVO){ cartMapper.updateCount(cartVO); };
    //    장바구니에 존재하는 상품인지 체크, 만약 존재한다면 상품 개수 리턴
    public Integer checkCart(CartVO cartVO){ return cartMapper.checkCart(cartVO); };
    //    장바구니 상품 추가
    public void save(CartVO cartVO){ cartMapper.insert(cartVO); };
    //    장바구니 상품 총 개수
    public Integer getTotal(Long memberNumber){ return cartMapper.getTotal(memberNumber); };
}
