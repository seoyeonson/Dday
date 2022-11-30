package com.example.dday.mapper;

import com.example.dday.domain.vo.PartnerDTO;
import com.example.dday.domain.vo.PartnerVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PartnerMapper {
//    파트너 정보 추가
    public void insert(PartnerDTO partnerDTO);
//    파트너 정보 수정
    public void update(PartnerDTO partnerDTO);
//
}
