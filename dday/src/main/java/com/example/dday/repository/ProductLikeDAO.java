package com.example.dday.repository;

import com.example.dday.domain.vo.ProductLikeVO;
import com.example.dday.mapper.ProductLikeMapper;
import com.example.dday.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductLikeDAO {
    private final ProductLikeMapper productLikeMapper;

    // 찜하기 ( 추가 )
    public void save(ProductLikeVO productLikeVO){
       productLikeMapper.insert(productLikeVO);
    }

    // 찜목록 삭제
    public void remove(ProductLikeVO productLikeVO){
        productLikeMapper.delete(productLikeVO);
    }

}
