package com.example.dday.mapper;

import com.example.dday.domain.vo.AddressVO;
import com.example.dday.domain.vo.Criteria;
import com.example.dday.domain.vo.ManagerDTO;
import com.example.dday.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {

    //목록 조회
    public List<ProductVO> selectMainProduct();

    //목록조회 2
    public List<ProductVO> selectMainProduct2();

    //목록조회 3
    public List<ProductVO> selectMainProduct3();

    //목록조회 4
    public List<ProductVO> selectMainProduct4();

    //목록조회 5
    public List<ProductVO> selectMainProduct5();
    //목록조회 6
    public List<ProductVO> selectMainProduct6();
}
