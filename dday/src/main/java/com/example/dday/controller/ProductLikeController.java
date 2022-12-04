package com.example.dday.controller;

import com.example.dday.domain.vo.ProductLikeVO;
import com.example.dday.service.ProductLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/productlike/*")
public class ProductLikeController {
    private ProductLikeService productLikeService;

    @ResponseBody
    @GetMapping("addProduct")
    public String addProductToList(ProductLikeVO productLikeVO){
        return productLikeService.clickLikeButton(productLikeVO);
    }
}


