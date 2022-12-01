package com.example.dday.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PartnerMapperTest {

    @Autowired
    private PartnerMapper partnerMapper;

    @Test
    public void selectTest() {
        log.info("partner : " + partnerMapper.select(1L));
    }
}
