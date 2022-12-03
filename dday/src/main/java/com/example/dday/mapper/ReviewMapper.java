package com.example.dday.mapper;

import com.example.dday.domain.vo.ProductCriteria;
import com.example.dday.domain.vo.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReviewMapper {
    /* 리뷰 페이징 */
    public List<ReviewDTO> selectAllReview(ProductCriteria productCriteria);

    /* 리뷰 총 갯수(페이징) */
    public int getReviewTotal(int productNumber);
}
