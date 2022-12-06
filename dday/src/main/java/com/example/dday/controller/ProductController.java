package com.example.dday.controller;

import com.example.dday.domain.vo.ProductPageDTO;
import com.example.dday.domain.vo.ProductVO;
import com.example.dday.domain.vo.ProductCriteria;
import com.example.dday.mapper.ProductMapper;
import com.example.dday.mapper.SearchProductMapper;
import com.example.dday.service.ProductService;
import com.example.dday.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/product/*")
public class ProductController {
    private final ProductService productService;
    private final ProductVO productVO;

    @Autowired(required = false)
    private ProductMapper productMapper;

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

    @GetMapping("/newCategory")
    public void newCategory(@RequestParam(value = "highlow", required = false) String productSort,
                            @RequestParam(value = "filterSearch", required = false) String filterSearch,
                            @RequestParam(value = "productColNum", required = false) String productColNum,
                            ProductCriteria productCriteria,Model model, Model SearchList){
        if(productCriteria.getPage() == 0){
            productCriteria.create(1,12);
        }
        model.addAttribute("freshes" ,productService.showNew());
        model.addAttribute("pagination", new ProductPageDTO().createProductPageDTO(productCriteria, productService.getFreshTotal()));
        model.addAttribute("freshesTotal",productService.getFreshTotal());

        List<String> filterSearchList = null;


        System.out.println("filterSearch        >>" + filterSearch + "]");
        if(filterSearch != null && !filterSearch.equals("")) {

            filterSearchList = new ArrayList(Arrays.asList((String[]) filterSearch.split(",")));
        }else{
            filterSearchList = new ArrayList<String>();
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("highlow", productSort);
        paramMap.put("filterSearch", filterSearchList);
        paramMap.put("productColNum", productColNum);

        log.info("productColNum : " + productColNum);

        /*System.out.println("filterSearchList.size()        >>" + filterSearchList.size());*/
        System.out.println("filterSearchList         >>" + filterSearchList);
        System.out.println("productSort     >>"+productSort);
        System.out.println("columnNum   >>" +productColNum);

        model.addAttribute("filterSearchList", filterSearchList);
//        int totalCount = productMapper.getProductCount(paramMap);

        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        System.out.println("성공");
        productVOList = productMapper.getProductList(paramMap);
        SearchList.addAttribute("productList",productVOList);
        System.out.println(productVOList);

    }

    @GetMapping("/bestCategory")
    public void bestCategory(@RequestParam(value = "highlow", required = false) String productSort,
                             @RequestParam(value = "filterSearch", required = false) String filterSearch,
                             @RequestParam(value = "productColNum", required = false) String productColNum,
                             ProductCriteria productCriteria,Model model, Model SearchList){
        if(productCriteria.getPage() == 0){
            productCriteria.create(1,12);
        }
        model.addAttribute("bests", productService.showBest(productCriteria));
        model.addAttribute("pagination",new ProductPageDTO().createProductPageDTO(productCriteria, productService.getBestTotal()));
        model.addAttribute("bestsTotal",productService.getBestTotal());

        List<String> filterSearchList = null;


        System.out.println("filterSearch        >>" + filterSearch + "]");
        if(filterSearch != null && !filterSearch.equals("")) {

            filterSearchList = new ArrayList(Arrays.asList((String[]) filterSearch.split(",")));
        }else{
            filterSearchList = new ArrayList<String>();
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("highlow", productSort);
        paramMap.put("filterSearch", filterSearchList);
        paramMap.put("productColNum", productColNum);

        /*System.out.println("filterSearchList.size()        >>" + filterSearchList.size());*/
        System.out.println("filterSearchList         >>" + filterSearchList);
        System.out.println("productSort     >>"+productSort);
        System.out.println("columnNum   >>" +productColNum);

        model.addAttribute("filterSearchList", filterSearchList);
//        int totalCount = productMapper.getProductCount(paramMap);

        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        System.out.println("성공");
        productVOList = productMapper.getProductList(paramMap);
        SearchList.addAttribute("productList",productVOList);
        System.out.println(productVOList);

    }

    @GetMapping(value="/saleCategory")
    public void saleCategory(@RequestParam(value = "highlow", required = false) String productSort,
                             @RequestParam(value = "filterSearch", required = false) String filterSearch,
                             @RequestParam(value = "productColNum", required = false) Integer productColNum,
                             ProductCriteria productCriteria,Model model, Model SearchList){
        if(productCriteria.getPage() == 0){
            productCriteria.create(1,12);
        }
        int col4 = 4;
        productVO.setProductColNum(col4);
        model.addAttribute("sales", productService.showSale(productCriteria));
        log.info("showSleController: " + productCriteria);
        log.info("colNum~~~~~~~~~~" + productColNum);
        model.addAttribute("pagination",new ProductPageDTO().createProductPageDTO(productCriteria, productService.getSaleTotal()));
        model.addAttribute("salesTotal",productService.getSaleTotal());

        List<String> filterSearchList = null;


        System.out.println("filterSearch        >>" + filterSearch + "]");
        if(filterSearch != null && !filterSearch.equals("")) {

            filterSearchList = new ArrayList(Arrays.asList((String[]) filterSearch.split(",")));
        }else{
            filterSearchList = new ArrayList<String>();
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("highlow", productSort);
        paramMap.put("filterSearch", filterSearchList);
        paramMap.put("productColNum", productColNum);

        /*System.out.println("filterSearchList.size()        >>" + filterSearchList.size());*/
        System.out.println("filterSearchList         >>" + filterSearchList);
        System.out.println("productSort     >>"+productSort);
        System.out.println("columnNum   >>" +productColNum);

        model.addAttribute("filterSearchList", filterSearchList);
//        int totalCount = productMapper.getProductCount(paramMap);

        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        System.out.println("성공");
        productVOList = productMapper.getProductList(paramMap);
        SearchList.addAttribute("productList",productVOList);
        System.out.println(productVOList);

    }



    @GetMapping("/todayCategory")
    public void todayCategory(@RequestParam(value = "highlow", required = false) String productSort,
                              @RequestParam(value = "filterSearch", required = false) String filterSearch,
                              @RequestParam(value = "productColNum", required = false) String productColNum,
                              ProductCriteria productCriteria,Model model, Model SearchList){
        if(productCriteria.getPage() == 0){
            productCriteria.create(1,12);
        }
        model.addAttribute("todays", productService.showToday(productCriteria));
        model.addAttribute("pagination",new ProductPageDTO().createProductPageDTO(productCriteria, productService.getTodayTotal()));
        model.addAttribute("todaysTotal",productService.getTodayTotal());

        List<String> filterSearchList = null;


        System.out.println("filterSearch        >>" + filterSearch + "]");
        if(filterSearch != null && !filterSearch.equals("")) {

            filterSearchList = new ArrayList(Arrays.asList((String[]) filterSearch.split(",")));
        }else{
            filterSearchList = new ArrayList<String>();
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("highlow", productSort);
        paramMap.put("filterSearch", filterSearchList);
        paramMap.put("productColNum", productColNum);

        /*System.out.println("filterSearchList.size()        >>" + filterSearchList.size());*/
        System.out.println("filterSearchList         >>" + filterSearchList);
        System.out.println("productSort     >>"+productSort);
        System.out.println("columnNum   >>" +productColNum);

        model.addAttribute("filterSearchList", filterSearchList);
//        int totalCount = productMapper.getProductCount(paramMap);

        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        System.out.println("성공");
        productVOList = productMapper.getProductList(paramMap);
        SearchList.addAttribute("productList",productVOList);
        System.out.println(productVOList);

    }



}