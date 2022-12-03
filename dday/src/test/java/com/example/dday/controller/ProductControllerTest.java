package com.example.dday.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class ProductControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void newCategory() throws Exception{
        log.info("news: "+ mockMvc.perform(MockMvcRequestBuilders.get("/product/newCategory")).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void bestCategory() throws Exception{
        log.info("news: "+ mockMvc.perform(MockMvcRequestBuilders.get("/product/bestCategory")
                .param("page", "1")
                .param("amount", "10")
        ).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void saleCategory() throws Exception{
        log.info("news: "+ mockMvc.perform(MockMvcRequestBuilders.get("/product/saleCategory")
                .param("page", "1")
                .param("amount", "10")
        ).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void todayCategory() throws Exception{
        log.info("news: "+ mockMvc.perform(MockMvcRequestBuilders.get("/product/todayCategory")
                .param("page", "1")
                .param("amount", "10")
        ).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void categoryDetail() throws Exception{
        log.info("model map: " + mockMvc.perform(MockMvcRequestBuilders.get("/product/categoryDetail").param("productNumber", "9"))
                .andReturn().getModelAndView().getModelMap());
    }

    @Test
    void todayCategoryDetail() {
    }
}