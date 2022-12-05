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
}
