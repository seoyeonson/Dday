package com.example.dday.service;

import com.example.dday.domain.vo.ProductCriteria;
import com.example.dday.domain.vo.ProductDetailDTO;
import com.example.dday.domain.vo.ProductVO;
import com.example.dday.repository.ProductDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductDAO productDAO;

    // 추가
    public void register(ProductVO productVO){
        productVO.setProductSalePrice((long)(productVO.getProductPrice() * (1-productVO.getProductSalePercent()/(double)100)));
        productDAO.save(productVO);
    }
    // 상품 한개 조회
    public ProductVO show(Long productNumber){
        return productDAO.findById(productNumber);
    }
    // 당일판매상품 한개 조회
    public ProductVO showTodayOne(Long productNumber){
        return productDAO.findTodayById(productNumber);
    }
    // 당일판매상품 조회
    public List<ProductVO> showToday(ProductCriteria productCriteria){
        return productDAO.findToday(productCriteria);
    }
    // 베스트 상품 조회
    public List<ProductVO> showBest(ProductCriteria productCriteria){
        return productDAO.findBest(productCriteria);
    }
    // 신상품 조회
    public List<ProductVO> showNew(){
        return productDAO.findNew();
    }
    // 대박할인상품 조회
    public List<ProductVO> showSale(ProductCriteria productCriteria){
        return productDAO.findSale(productCriteria);
    }
    // 상품 조회수
    public int modifyViewCount(Long productNumber){
        return productDAO.updateViewCount(productNumber);
    }
    //    전체 개수
    public int getTotal() {
        return productDAO.findCountAll();
    }

    public int getBestTotal(){return productDAO.findCountBest();}
    public int getSaleTotal(){return productDAO.findCountSale();}
    public int getTodayTotal(){return productDAO.findCountToday();}
    public int getFreshTotal(){return productDAO.findCountFresh();}

    public ProductDetailDTO showPartnerDetail(Long productNumber){
        return productDAO.findPartnerById(productNumber);
    }
}
