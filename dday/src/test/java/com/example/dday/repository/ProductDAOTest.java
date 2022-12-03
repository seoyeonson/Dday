package com.example.dday.repository;

import com.example.dday.domain.vo.ProductCriteria;
import com.example.dday.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ProductDAOTest {
    @Autowired
    private ProductDAO productDAO;

    @Test
    public void saveTest() {
        ProductVO productVO = new ProductVO();
        productVO.create("우유", "생수.음료.우유.커피", 1500L,10L,"20221127","20221130", "맛있어요","목초먹은 젖소에서 짜낸 신선한 우유에요", "썸네일","본문이미지", "20221128", 20L);
        productDAO.save(productVO);
    }

    @Test
    public void findByIdTest(){
        log.info("product: " + productDAO.findById(2L));
    }

    @Test
    public void findAllBestTest(){
        productDAO.findBest(new ProductCriteria().create(1, 10)).stream().map(ProductVO::getProductName).forEach(log::info);
    }
}