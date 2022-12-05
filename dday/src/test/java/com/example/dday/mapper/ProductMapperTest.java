package com.example.dday.mapper;

import com.example.dday.domain.vo.ProductCriteria;
import com.example.dday.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void insertTest() {
        ProductVO productVO = new ProductVO();
        productVO.create("우유", "생수.음료.우유.커피", 1500L,10L,"20221127","20221130", "맛있어요","목초먹은 젖소에서 짜낸 신선한 우유에요", "썸네일","본문이미지", "20221128", 60L);
        productMapper.insert(productVO);
    }

    @Test
    public void insertTodayTest() {
        ProductVO productVO = new ProductVO();
        productVO.create2("당근", "채소", 5000L,8L,"20221129","20221205", "완숙이에요","아삭한 당근이에요!", "썸네일","본문이미지", "20221128", "20221205", 70L);
        productMapper.insert(productVO);
    }

    @Test
    public void selectTest(){
        log.info("product: " + productMapper.select(2L));
    }

    @Test
    public void selectBestTest(){
        productMapper.selectBest(new ProductCriteria().create(1, 10)).stream().map(ProductVO::getProductName).forEach(log::info);
    }

    @Test
    public void selectTodayOne(){
        log.info("product: " + productMapper.selectTodayOne(21L));
    }

    @Test
    public void selectPartnerTest(){
        log.info("partnerDetail : " + productMapper.selectPartner(76L));
    }
}
