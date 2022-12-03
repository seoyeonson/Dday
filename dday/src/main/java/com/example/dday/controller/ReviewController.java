package com.example.dday.controller;

import com.example.dday.domain.vo.*;
import com.example.dday.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/review/*")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping(value="/list" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ReviewPageDTO reviewListPOST(ProductCriteria productCriteria) {
        log.info("들어옴");
        return reviewService.reviewList(productCriteria);
    }


}























