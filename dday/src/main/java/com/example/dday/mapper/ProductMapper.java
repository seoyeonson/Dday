package com.example.dday.mapper;

import com.example.dday.domain.vo.ProductCriteria;
import com.example.dday.domain.vo.ProductDetailDTO;
import com.example.dday.domain.vo.ProductPageDTO;
import com.example.dday.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
    // 추가
    public void insert(ProductVO productVO);
    // 상품 한개 조회
    public ProductVO select(Long productNumber);
    // 당일판매상품 한개 조회
    public ProductVO selectTodayOne(Long productNumber);
    // 당일판매상품 조회
    public List<ProductVO> selectToday(ProductCriteria productCriteria);
    // 베스트 상품 조회
    public List<ProductVO> selectBest(ProductCriteria productCriteria);
    // 신상품 조회
    public List<ProductVO> selectNew();
    // 대박할인상품 조회
    public List<ProductVO> selectSale(ProductCriteria productCriteria);
    // 상품 조회수
    public int updateViewCount(Long productNumber);
    // 전체 개수
    public int getTotal();

    // 당일판매.베스트.대박할인.신상품
    public int getTodayTotal();
    public int getBestTotal();
    public int getSaleTotal();
    public int getFreshTotal();

    // 파트너 정보
    public ProductDetailDTO selectPartner(Long productNumber);

    public List<ProductVO> getProductList(Map<String, Object> map);

    public int getProductCount(Map<String, Object> map);

}
