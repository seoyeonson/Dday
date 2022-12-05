package com.example.dday.repository;
import com.example.dday.domain.vo.ProductVO;
import com.example.dday.mapper.MainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class MainDAO {
    private final MainMapper mainMapper;

    //전체 조회
    public List<ProductVO> findMainProduct() {
        return  mainMapper.selectMainProduct();
    }
}
