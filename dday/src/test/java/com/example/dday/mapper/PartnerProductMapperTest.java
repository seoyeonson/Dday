package com.example.dday.mapper;

import com.example.dday.domain.vo.PartnerCriteria;
import com.example.dday.domain.vo.PartnerVO;
import com.example.dday.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PartnerProductMapperTest {
    @Autowired
    private PartnerProductMapper partnerProductMapper;

    @Test
    public void selectAllTest() {
        partnerProductMapper.selectAll(new PartnerCriteria().create(1, 4)).stream().map(ProductVO::getProductName).forEach(log::info);
    }
}
