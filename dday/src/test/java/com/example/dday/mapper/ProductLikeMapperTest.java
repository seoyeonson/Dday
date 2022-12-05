package com.example.dday.mapper;

import com.example.dday.domain.vo.CartVO;
import com.example.dday.domain.vo.ProductLikeVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ProductLikeMapperTest {
    @Autowired
    ProductLikeMapper productLikeMapper;

    @Test
    public void insertTest() {
        ProductLikeVO productLikeVO = new ProductLikeVO();
        productLikeVO.create(193L, 1L);
        productLikeMapper.insert(productLikeVO);
    }
}