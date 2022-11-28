package com.example.dday.repository;

import com.example.dday.domain.vo.ProductVO;
import com.example.dday.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;

    // 추가
    public void save(ProductVO productVO){
        productMapper.insert(productVO);
    }
    // 상품 한개 조회
    public ProductVO findById(Long productNumber){
        return productMapper.select(productNumber);
    }
    // 당일판매상품 조회
    public List<ProductVO> findToday(){
        return productMapper.selectToday();
    }
    // 베스트 상품 조회
    public List<ProductVO> findBest(){
        return productMapper.selectBest();
    }
    // 신상품 조회
    public List<ProductVO> findNew(){
        return productMapper.selectNew();
    }
    // 대박할인상품 조회
    public List<ProductVO> findSale(){
        return productMapper.selectSale();
    }
}
