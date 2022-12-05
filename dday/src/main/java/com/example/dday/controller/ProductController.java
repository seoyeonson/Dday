package com.example.dday.controller;

import com.example.dday.domain.vo.ProductPageDTO;
import com.example.dday.domain.vo.ProductVO;
import com.example.dday.domain.vo.ProductCriteria;
import com.example.dday.mapper.ProductMapper;
import com.example.dday.service.ProductService;
import com.example.dday.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product/*")
public class ProductController {
    private final ProductService productService;
    private final ProductVO productVO;

    @GetMapping("/newCategory")
    public void newCategory(ProductCriteria productCriteria,Model model){
        if(productCriteria.getPage() == 0){
            productCriteria.create(1,12);
        }
        model.addAttribute("freshes" ,productService.showNew());
        model.addAttribute("pagination", new ProductPageDTO().createProductPageDTO(productCriteria, productService.getFreshTotal()));
        model.addAttribute("freshesTotal",productService.getFreshTotal());
    }

    @GetMapping("/bestCategory")
    public void bestCategory(ProductCriteria productCriteria,Model model){
        if(productCriteria.getPage() == 0){
            productCriteria.create(1,12);
        }
        model.addAttribute("bests", productService.showBest(productCriteria));
        model.addAttribute("pagination",new ProductPageDTO().createProductPageDTO(productCriteria, productService.getBestTotal()));
        model.addAttribute("bestsTotal",productService.getBestTotal());
    }

    @GetMapping("/saleCategory")
    public void saleCategory(ProductCriteria productCriteria,Model model){
        if(productCriteria.getPage() == 0){
            productCriteria.create(1,12);
        }
        model.addAttribute("sales", productService.showSale(productCriteria));
        model.addAttribute("pagination",new ProductPageDTO().createProductPageDTO(productCriteria, productService.getSaleTotal()));
        model.addAttribute("salesTotal",productService.getSaleTotal());
    }

    @GetMapping("/todayCategory")
    public void todayCategory(ProductCriteria productCriteria,Model model){
        if(productCriteria.getPage() == 0){
            productCriteria.create(1,12);
        }
        model.addAttribute("todays", productService.showToday(productCriteria));
        model.addAttribute("pagination",new ProductPageDTO().createProductPageDTO(productCriteria, productService.getTodayTotal()));
        model.addAttribute("todaysTotal",productService.getTodayTotal());
    }

    @RequestMapping(value = "/categoryDetail")
    public String categoryDetail(@RequestParam("productNumber") Long productNumber, Model model){
        productService.modifyViewCount(productNumber);
        model.addAttribute("product", productService.show(productNumber));
        model.addAttribute("partner", productService.showPartnerDetail(productNumber));
        return "product/categoryDetail";
    }

    @RequestMapping(value="/todayCategoryDetail")
    public String todayCategoryDetail(@RequestParam("productNumber") Long productNumber, Model model){
        model.addAttribute("todayProduct", productService.showTodayOne(productNumber));
        model.addAttribute("partner", productService.showPartnerDetail(productNumber));
        return "/product/todayCategoryDetail";
    }


}
