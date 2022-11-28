package com.example.dday.mapper;

import com.example.dday.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void insertTest() {
        ProductVO productVO = new ProductVO();
        productVO.create("우유", "생수.음료.우유.커피", 1500L,10L,"20221127","20221130", "맛있어요","목초먹은 젖소에서 짜낸 신선한 우유에요", "썸네일","본문이미지", "20221128", 20L);
        productMapper.insert(productVO);
    }

    @Test
    public void selectTest(){
        log.info("product: " + productMapper.select(2L));
    }

    @Test
    public void selectNewTest(){
        productMapper.selectNew().stream().map(ProductVO::getProductName).forEach(log::info);
    }
}
