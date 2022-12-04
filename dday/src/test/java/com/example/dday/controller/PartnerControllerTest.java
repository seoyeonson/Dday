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

@SpringBootTest
@Slf4j
public class PartnerControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void info() throws Exception {
        log.info("model map: " + mockMvc.perform(MockMvcRequestBuilders.get("/partner/partner_info").param("partnerNumber", "1"))
                .andReturn().getModelAndView().getModelMap());
    }

    @Test
    void updateInfo() throws Exception {
        log.info("model map: " + mockMvc.perform(MockMvcRequestBuilders.post("/partner/partner_change_info")
                .param("partnerNumber", "2")
                .param("partnerStoreName", "테스트")
                .param("partnerRegistrationNumber1", "444")
                .param("partnerRegistrationNumber2", "55")
                .param("partnerRegistrationNumber3", "6666")
                .param("partnerOwnerName", "테스트")
                .param("partnerOwnerEmail", "test@gmail.com")
                .param("partnerStorePostcode", "12345")
                .param("partnerStoreAddress", "테스트")
                .param("partnerStoreDetailedAddress", "테스트")
                .param("partnerOwnerPhoneNumber", "01011112222")
        ).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void productList() throws Exception {
        log.info("products: " + mockMvc.perform(MockMvcRequestBuilders.get("/partner/partner_management")
                .param("page", "1")
                .param("amount", "4")
        ).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void productInfo() throws Exception {
        log.info("product: " + mockMvc.perform(MockMvcRequestBuilders.get("/partner/partnerProductChange")
                .param("productNumber", "2")).andReturn().getModelAndView().getModelMap());
    }
}
