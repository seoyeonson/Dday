package com.example.dday.repository;

import com.example.dday.domain.vo.ProductCriteria;
import com.example.dday.domain.vo.ProductDetailDTO;
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
    // 당일판매상품 한개 조회
    public ProductVO findTodayById(Long productNumber){
        return productMapper.selectTodayOne(productNumber);
    }
    // 당일판매상품 조회
    public List<ProductVO> findToday(ProductCriteria productCriteria){
        return productMapper.selectToday(productCriteria);
    }
    // 베스트 상품 조회
    public List<ProductVO> findBest(ProductCriteria productCriteria){
        return productMapper.selectBest(productCriteria);
    }
    // 신상품 조회
    public List<ProductVO> findNew(){
        return productMapper.selectNew();
    }
    // 대박할인상품 조회
    public List<ProductVO> findSale(ProductCriteria productCriteria){
        return productMapper.selectSale(productCriteria);
    }
    // 상품 조회수
    public int updateViewCount(Long productNumber){
        return productMapper.updateViewCount(productNumber);
    }
    //    전체 개수
    public int findCountAll(){
        return productMapper.getTotal();
    }

    public int findCountBest(){return productMapper.getBestTotal();}
    public int findCountSale(){return productMapper.getSaleTotal();}
    public int findCountFresh(){return productMapper.getFreshTotal();}
    public int findCountToday(){return productMapper.getTodayTotal();}

    public ProductDetailDTO findPartnerById(Long productNumber){return productMapper.selectPartner(productNumber);}
}
