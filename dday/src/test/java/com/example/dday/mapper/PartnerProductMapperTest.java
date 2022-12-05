package com.example.dday.mapper;

import com.example.dday.domain.vo.PartnerCriteria;
import com.example.dday.domain.vo.PartnerProductDTO;
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

    @Test
    public void selectTest() {
        log.info("product: " + partnerProductMapper.select(1l));
    }


    @Test
    public void insertTest() {
        PartnerProductDTO partnerProductDTO = new PartnerProductDTO();
        partnerProductDTO.create("애비앙", "생수.음료.우유.커피", Long.valueOf(2000), Long.valueOf(10), "2022-01-01 00:00:00", "2024-01-01 00:00:00", "맛도링", "애비앙 아이가", "썸네일이미지", "본문이미지", "2022-10-10 00:00:00", "5", Long.valueOf(5), Long.valueOf(1));
        partnerProductMapper.insert(partnerProductDTO);
        log.info("productNumber: " + partnerProductDTO.getProductNumber());
    }
}
