package com.example.dday.mapper;

import com.example.dday.domain.vo.ProductLikeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductLikeMapper {
    // 찜하기 ( 추가 )
    public void insert(ProductLikeVO productLikeVO);
    // 찜 목록 1개 삭제
    public void delete(ProductLikeVO productLikeVO);
}
