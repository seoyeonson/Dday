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

    //전체 조회2
    public List<ProductVO> findMainProduct2() {
        return  mainMapper.selectMainProduct2();
    }
    //전체 조회3
    public List<ProductVO> findMainProduct3() {
        return  mainMapper.selectMainProduct3();
    }
    //전체 조회4
    public List<ProductVO> findMainProduct4() {
        return  mainMapper.selectMainProduct4();
    }
    //전체 조회5
    public List<ProductVO> findMainProduct5() {
        return  mainMapper.selectMainProduct5();
    }
    //전체 조회6
    public List<ProductVO> findMainProduct6() {
        return  mainMapper.selectMainProduct6();
    }





}
