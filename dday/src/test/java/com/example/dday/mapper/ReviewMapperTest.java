package com.example.dday.mapper;

import com.example.dday.domain.vo.ProductCriteria;
import com.example.dday.domain.vo.ProductVO;
import com.example.dday.domain.vo.ReviewDTO;
import com.example.dday.domain.vo.ReviewVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class ReviewMapperTest {

    @Autowired
    ReviewMapper reviewMapper;

    @Test
    void selectAllReview() {
        ProductCriteria productCriteria = new ProductCriteria().create2(1, 5, 200);
        log.info("cri : " + productCriteria);
//        reviewMapper.selectAllReview(new ProductCriteria().create2(1, 5, 200)).stream().map(ReviewDTO::getReviews).forEach(reviews -> log.info(reviews.toString()));
        log.info("reviews : " + reviewMapper.selectAllReview(productCriteria));
    }

    @Test
    void getReviewTotal() {
        reviewMapper.getReviewTotal(200);
    }
}