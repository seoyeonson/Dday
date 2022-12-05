package com.example.dday.service;

import com.example.dday.domain.vo.ProductVO;
/*import com.example.dday.domain.vo.SearchProductCriteria;*/
import com.example.dday.mapper.SearchProductMapper;
import com.example.dday.repository.SearchProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchProductService {
    @Autowired
    SearchProductDAO searchProductDAO;
}