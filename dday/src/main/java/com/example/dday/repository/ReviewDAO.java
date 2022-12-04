package com.example.dday.repository;

import com.example.dday.domain.vo.ProductCriteria;
import com.example.dday.domain.vo.ReviewDTO;
import com.example.dday.domain.vo.ReviewProductDTO;
import com.example.dday.domain.vo.ReviewVO;
import com.example.dday.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewDAO {
    private final ReviewMapper reviewMapper;

    public List<ReviewProductDTO> findAll(ProductCriteria productCriteria){
        return reviewMapper.selectAllReview(productCriteria);
    }

    public int count(int productNumber){
        return reviewMapper.getReviewTotal(productNumber);
    }
}
