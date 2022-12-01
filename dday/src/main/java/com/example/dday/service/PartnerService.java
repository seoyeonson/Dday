package com.example.dday.service;

import com.example.dday.domain.vo.PartnerDTO;
import com.example.dday.repository.PartnerDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartnerService {
    private final PartnerDAO partnerDAO;

    //    추가
    public void register(PartnerDTO partnerDTO) {
        partnerDAO.save(partnerDTO);
    }

    //    수정
    public void modify(PartnerDTO partnerDTO) {
        partnerDAO.setPartnerVO(partnerDTO);
    }

//    조회
    public PartnerDTO show(Long partnerNumber) {
        PartnerDTO partnerDTO = new PartnerDTO();
        partnerDTO.create(partnerDAO.findById(partnerNumber));
        return partnerDTO;
    }
}
