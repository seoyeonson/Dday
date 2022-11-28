package com.example.dday.mapper;

import com.example.dday.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    // 추가
    public void insert(ProductVO productVO);
    // 상품 한개 조회
    public ProductVO select(Long productNumber);
    // 당일판매상품 조회
    public List<ProductVO> selectToday();
    // 베스트 상품 조회
    public List<ProductVO> selectBest();
    // 신상품 조회
    public List<ProductVO> selectNew();
    // 대박할인상품 조회
    public List<ProductVO> selectSale();

}
