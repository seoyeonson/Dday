package com.example.dday.mapper;

import com.example.dday.domain.vo.PartnerCriteria;
import com.example.dday.domain.vo.PartnerProductDTO;
import com.example.dday.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PartnerProductMapper {
    //    제품 등록
    public void insert(PartnerProductDTO partnerProductDTO);

    //    제품 정보 수정
    public void update(PartnerProductDTO partnerProductDTO);

    //    제품 정보 조회
    public ProductVO select(Long productNumber);

    //    제품 전체 조회
    public List<ProductVO> selectAll(PartnerCriteria partnerCriteria);

    //     제품 전체 개수
    public int getTotal();
}