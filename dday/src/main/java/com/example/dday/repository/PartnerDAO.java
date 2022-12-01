package com.example.dday.repository;

import com.example.dday.domain.vo.PartnerDTO;
import com.example.dday.domain.vo.PartnerVO;
import com.example.dday.mapper.PartnerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PartnerDAO {
    private final PartnerMapper partnerMapper;

    //    추가
    public void save(PartnerDTO partnerDTO) {
        partnerMapper.insert(partnerDTO);
    }

    //    수정
    public void setPartnerVO(PartnerDTO partnerDTO) {
        partnerMapper.update(partnerDTO);
    }

    //    조회
    public PartnerVO findById(Long partnerNumber) {
        return partnerMapper.select(partnerNumber);
    }
}
