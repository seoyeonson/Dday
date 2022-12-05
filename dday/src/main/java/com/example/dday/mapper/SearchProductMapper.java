package com.example.dday.mapper;

import com.example.dday.domain.vo.ProductDetailDTO;
import com.example.dday.domain.vo.ProductVO;
/*import com.example.dday.domain.vo.SearchProductCriteria;*/
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SearchProductMapper {


    public List<ProductVO> getProductList(Map<String, Object> map);

    public int getProductCount(Map<String, Object> map);

    public ProductDetailDTO selectPartner(Long productNumber);

    public List<ProductVO> selectNew();
    public int getFreshTotal();

}


