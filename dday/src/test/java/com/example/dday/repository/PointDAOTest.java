package com.example.dday.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class PointDAOTest {

    @Autowired
    private PointDAO pointDAO;

    @Test
    public void getPointTotalTest(){
        log.info("적립금: "  + pointDAO.findPointTotalByNumber(26L));
    }


}