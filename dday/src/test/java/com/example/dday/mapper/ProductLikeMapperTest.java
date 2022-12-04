package com.example.dday.mapper;

import com.example.dday.domain.vo.ProductLikeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ProductLikeMapperTest {
    @Autowired
    private ProductLikeMapper productLikeMapper;

    @Test
    void insertTest() {
        ProductLikeVO productLikeVO = new ProductLikeVO();
        productLikeVO.create(193L, 1L);
        productLikeMapper.insert(productLikeVO);
    }

//    @Test
//    void deleteTest() {
//        ProductLikeVO productLikeVO = new ProductLikeVO();
//        productLikeVO.setProductNumber(193L);
//        productLikeVO.setMemberNumber(1L);
//        productLikeMapper.delete(productLikeVO);
//    }
}