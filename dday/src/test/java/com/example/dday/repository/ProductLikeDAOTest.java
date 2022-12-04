package com.example.dday.repository;

import com.example.dday.domain.vo.ProductCriteria;
import com.example.dday.domain.vo.ProductLikeVO;
import com.example.dday.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ProductLikeDAOTest {
    @Autowired
    ProductLikeDAO productLikeDAO;

    @Test
    void saveTest() {
        ProductLikeVO productLikeVO = new ProductLikeVO();
        productLikeVO.create(193L, 1L);
        productLikeDAO.save(productLikeVO);
    }

//    @Test
//    void findLikeListByMemberNumberTest() {
//        ProductLikeVO productLikeVO = new ProductLikeVO();
//        productLikeVO.setMemberNumber(1L);
//        productLikeVO.setProductNumber(193L);
//        productLikeDAO.findLikeListByMemberNumber(productLikeVO.getMemberNumber());
//    }
//
//    @Test
//    void remove() {
//    }
//
//    @Test
//    void findByProductNumberWithMemberNumber() {
//        log.info("productLike: " + productLikeDAO.findByProductNumberWithMemberNumber(productLikeVO));
//    }
}