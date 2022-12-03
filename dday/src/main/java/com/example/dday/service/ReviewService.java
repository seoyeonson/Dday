package com.example.dday.service;

import com.example.dday.domain.vo.ProductCriteria;
import com.example.dday.domain.vo.ProductPageDTO;
import com.example.dday.domain.vo.ReviewPageDTO;
import com.example.dday.domain.vo.ReviewVO;
import com.example.dday.mapper.ReviewMapper;
import com.example.dday.repository.ReviewDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewDAO reviewDAO;
    private final ReviewMapper reviewMapper;

    /* 리뷰 페이징 */
    public ReviewPageDTO reviewList(ProductCriteria productCriteria) {
        ReviewPageDTO reviewPageDTO = new ReviewPageDTO();

        reviewPageDTO.setList(reviewMapper.selectAllReview(productCriteria));
        reviewPageDTO.setPageInfo(new ProductPageDTO(productCriteria, reviewMapper.getReviewTotal(productCriteria.getProductNumber())));
        log.info("productNumber : " + productCriteria.getProductNumber());

        return reviewPageDTO;
    }

}
