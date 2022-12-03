package com.example.dday.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class PointServiceTest {
    @Autowired
    private PointService pointService;

    @Test
    public void getPointTotalTest(){
        log.info("적립금: " + pointService.findPointTotalByNumber(26L));
    }

}