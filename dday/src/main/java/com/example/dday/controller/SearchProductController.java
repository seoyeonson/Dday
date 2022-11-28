package com.example.dday.controller;

import com.example.dday.domain.vo.ProductVO;
import com.example.dday.mapper.SearchProductMapper;
import com.example.dday.service.SearchProductService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.dday.mapper.SearchProductMapper;

@Controller
@RequestMapping("/search")
public class SearchProductController {

    @Autowired(required = false)
    private SearchProductMapper searchProductMapper;

    @Autowired
    SearchProductService searchProductService;

    @RequestMapping("/search")
    public @ResponseBody  ResponseEntity<List<ProductVO>> searchProduct(@RequestParam(value = "productName", required = true, defaultValue = "") String productName){

        Map<String,Object> paramMap = new HashMap<String, Object>();
        paramMap.put("productName",productName);
        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        System.out.println("성공");
        productVOList = searchProductMapper.getProductList(paramMap);
        System.out.println(productVOList);
        return new ResponseEntity(productVOList, HttpStatus.OK);

    }

    private List<ProductVO> searchProduct(@RequestParam("keyword") String productName, Model model) throws Exception{
        ProductVO productVO = new ProductVO();
        productVO.setProductName(productName);
        return searchProductService.searchProduct(productVO);
    }
}

