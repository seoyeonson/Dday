package com.example.dday.controller;

/*import com.example.dday.domain.vo.SearchProductPageDTO;*/
import com.example.dday.domain.vo.ProductCriteria;
import com.example.dday.domain.vo.ProductPageDTO;
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
        paramMap.put("productName", productName);
        paramMap.put("highlow", productSort);
        paramMap.put("filterSearch", filterSearchList);

        /*System.out.println("filterSearchList.size()        >>" + filterSearchList.size());*/
        System.out.println("filterSearchList         >>" + filterSearchList);
        System.out.println("productSort     >>"+productSort);

        model.addAttribute("keyword", productName);
        model.addAttribute("filterSearchList", filterSearchList);
        int totalCount = searchProductMapper.getProductCount(paramMap);
        countList.addAttribute("countList",totalCount);

        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        System.out.println("성공");
        productVOList = searchProductMapper.getProductList(paramMap);
        SearchList.addAttribute("productList",productVOList);
        System.out.println(productVOList);
    }
}