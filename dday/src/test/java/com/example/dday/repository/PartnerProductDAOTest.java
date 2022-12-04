package com.example.dday.repository;

import com.example.dday.domain.vo.PartnerCriteria;
import com.example.dday.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PartnerProductDAOTest {

    @Autowired
    private PartnerProductDAO partnerProductDAO;

    @Test
    public void findAllTest() {
        partnerProductDAO.findAll(new PartnerCriteria().create(1, 4)).stream().map(ProductVO::getProductName).forEach(log::info);
    }
}
