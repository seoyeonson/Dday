package com.example.dday.service;


import com.example.dday.domain.vo.PartnerCriteria;
import com.example.dday.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PartnerProductServiceTest {
    @Autowired
    private PartnerProductService partnerProductService;

    @Test
    public void showAllTest(){
        partnerProductService.showAll(new PartnerCriteria().create(1,4)).stream().map(ProductVO::getProductName).forEach(log::info);
    }
}
