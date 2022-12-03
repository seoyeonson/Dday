package com.example.dday.controller;

/*import com.example.dday.domain.vo.SearchProductPageDTO;*/
import com.example.dday.domain.vo.ProductVO;
/*import com.example.dday.domain.vo.SearchProductCriteria;*/
import com.example.dday.mapper.SearchProductMapper;
import com.example.dday.service.SearchProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/search")
public class SearchProductController {

    @Autowired(required = false)
    private SearchProductMapper searchProductMapper;

    @Autowired
    SearchProductService searchProductService;
/*
    @Autowired
    SearchProductCriteria searchProductCriteria;

    @Autowired
    SearchProductPageDTO searchProductPageDTO;*/

    /*@RequestMapping("/page")
    public @ResponseBody
    ResponseEntity<List<ProductVO>> searchProduct(@RequestParam(value = "productThumbnailName", required = true, defaultValue = "") String productThumbnailName
            , @RequestParam(value = "productPrice", required = true, defaultValue = "") Long productPrice) {

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("productThumbnailName", productThumbnailName);
        paramMap.put("productPrice", productPrice);
        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        System.out.println("성공");
        productVOList = searchProductMapper.getProductList(paramMap);
        System.out.println(productVOList);

        return new ResponseEntity(productVOList, HttpStatus.OK);

    }*/

    @GetMapping("/search")
    private void searchProduct(@RequestParam(value = "keyword", required = false) String productName,
                               @RequestParam(value = "highlow", required = false) String productSort,
                               @RequestParam(value = "filterSearch", required = false) String filterSearch,
                              /* @RequestParam(value = "endPageYN", required = false) String endPageYN,
                               @RequestParam(value = "searchPageNum", required = false) String searchPageNum,*/
                               Model model , Model SearchList, Model countList
          /*  , SearchProductCriteria criteria, Model paging*/) throws Exception {
        List<String> filterSearchList = null;
        System.out.println("filterSearch        >>" + filterSearch + "]");
        if(filterSearch != null && !filterSearch.equals("")) {

            filterSearchList = new ArrayList(Arrays.asList((String[]) filterSearch.split(",")));
        }else{
            filterSearchList = new ArrayList<String>();
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("productThumbnailName", productName);
        paramMap.put("highlow", productSort);
        paramMap.put("filterSearch", filterSearchList);

        /*System.out.println("filterSearchList.size()        >>" + filterSearchList.size());*/
        System.out.println("filterSearchList         >>" + filterSearchList);
        System.out.println("productSort     >>"+productSort);

        model.addAttribute("keyword", productName);
        model.addAttribute("filterSearchList", filterSearchList);
        int totalCount = searchProductMapper.getProductCount(paramMap);
        countList.addAttribute("countList",totalCount);


        /*paging*/
     /*   if(criteria.getPageNum() == 0){
            criteria.create(1,10);
        }

        paramMap.put("amount", criteria.getAmount());
        searchProductPageDTO.createPageDTO(criteria,totalCount);
        if(endPageYN != null && endPageYN.equals("Y")){
            paramMap.put("pageNum", searchProductPageDTO.getRealEnd());
        }else if(searchPageNum != null && !searchPageNum.equals("")){
            paramMap.put("pageNum", searchPageNum);
        }else{
            paramMap.put("pageNum", 1);
        }*/

        /*   ProductVO productVO = new ProductVO();*/
        /* productVO.setProductName(productName);*/

        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        System.out.println("성공");
        productVOList = searchProductMapper.getProductList(paramMap);
        SearchList.addAttribute("productList",productVOList);
        System.out.println(productVOList);
    }
}