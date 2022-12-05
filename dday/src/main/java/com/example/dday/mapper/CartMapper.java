package com.example.dday.mapper;

import com.example.dday.domain.vo.CartDTO;
import com.example.dday.domain.vo.CartVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CartMapper {
//    장바구니 목록
    public List<CartDTO> selectAll(Long memberNumber);
//    장바구니 상품 삭제
    public void delete(CartVO cartVO);
//    장바구니 상품 개수 수정
    public void updateCount(CartVO cartVO);
//    장바구니에 존재하는 상품인지 체크, 만약 존재한다면 상품 개수 리턴
    public Integer checkCart(CartVO cartVO);
//    장바구니 상품 추가
    public void insert(CartVO cartVO);
//    장바구니 상품 총 개수
    public Integer getTotal(Long memberNumber);
//    장바구니 상품 개수 수정
    public void update(CartVO cartVO);

}
