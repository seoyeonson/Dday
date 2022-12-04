package com.example.dday.mapper;

import com.example.dday.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductLikeMapper {
    public List<ProductVO> selectAll(Long memberNumber);
    public int getTotal(Long memberNumber);
    public void delete(Long productNumber, Long memberNumber);
}
