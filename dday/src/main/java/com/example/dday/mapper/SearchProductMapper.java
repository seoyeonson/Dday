package com.example.dday.mapper;

import com.example.dday.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SearchProductMapper {
    public List<ProductVO> getProductList(Map<String,Object> map);
}

