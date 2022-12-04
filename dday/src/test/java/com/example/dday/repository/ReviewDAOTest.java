package com.example.dday.repository;

import com.example.dday.domain.vo.ProductCriteria;
import com.example.dday.domain.vo.ProductVO;
import com.example.dday.domain.vo.ReviewDTO;
import com.example.dday.domain.vo.ReviewVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ReviewDAOTest {
    @Autowired
    ReviewDAO reviewDAO;
//
//    @Test
//    void findAllTest() {
//        reviewDAO.findAll(new ProductCriteria().create2(1, 5,200)).stream().map(ReviewVO::getReviewContent).forEach(reviews -> log.info(reviews.toString()));
//    }

    @Test
    void countTest() {
        reviewDAO.count(200);
    }
}