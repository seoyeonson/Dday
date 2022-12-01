package com.example.dday.repository;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PartnerDAOTest {

    @Autowired
    private PartnerDAO partnerDAO;

    @Test
    public void findByIdTest() {
        log.info("partner: " + partnerDAO.findById(1L));
    }
}
