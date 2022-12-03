package com.example.dday.service;

import com.example.dday.domain.vo.ProductCriteria;
import com.example.dday.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void registerTest() {
        ProductVO productVO = new ProductVO();
        productVO.create("우유", "생수.음료.우유.커피", 2500L,30L,"20221129","20221205", "우유에요","흰우유~ 아주 깔끔합니다!", "썸네일","본문이미지", "20221130", 10L);
        productVO.create2("테스트3", "생수.음료.우유.커피", 10000L,8L,"20221127","20221205", "아아시원해요","머신으로 내려마시는것 만큼 맛있어요", "썸네일","본문이미지", "20221130", "2022-11-29", 50L);
        productService.register(productVO);
    }

    @Test
    public void showTest(){
        log.info("product: " + productService.show(25L));
    }

    @Test
    public void showTodayOneTest(){
        log.info("product: " + productService.showTodayOne(21L));
    }

    @Test
    public void showNewTest(){
        productService.showNew().stream().map(ProductVO::getProductName).forEach(log::info);
    }

    @Test
    public void showSaleTest(){
        productService.showSale(new ProductCriteria().create(1, 10)).stream().map(ProductVO::getProductName).forEach(log::info);
    }

    @Test
    public void showTodayTest(){
        productService.showToday(new ProductCriteria().create(1, 10)).stream().map(ProductVO::getProductName).forEach(log::info);
    }

    @Test
    public void showBestTest(){
        productService.showBest(new ProductCriteria().create(1, 10)).stream().map(ProductVO::getProductName).forEach(log::info);
    }

    @Test
    public void modifyViewCountTest() {
        log.info("productCount: " + productService.modifyViewCount(37L));
    }
}