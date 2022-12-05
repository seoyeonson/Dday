package com.example.dday.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CartMapperTest {
    @Autowired
    private CartMapper cartMapper;

    @Test
    public void selectAllTest(){
        log.info("select :" + cartMapper.selectAll(26L));
    }
}