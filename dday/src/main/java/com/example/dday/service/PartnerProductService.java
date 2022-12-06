package com.example.dday.service;

import com.example.dday.domain.vo.PartnerCriteria;
import com.example.dday.domain.vo.PartnerProductDTO;
import com.example.dday.domain.vo.ProductVO;
import com.example.dday.repository.PartnerProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartnerProductService {
    private final PartnerProductDAO partnerProductDAO;

    //    제품 정보 추가
    public void register(PartnerProductDTO partnerProductDTO) {
        partnerProductDAO.save(partnerProductDTO);
    }

    public void registerToday(PartnerProductDTO partnerProductDTO) {
        partnerProductDAO.saveToday(partnerProductDTO);
    }

    //    제품 정보 수정
    public void modify(PartnerProductDTO partnerProductDTO) {
        partnerProductDAO.setProductVO(partnerProductDTO);
    }

    //    삭제
    public void remove(Long productNumber) {
        partnerProductDAO.remove(productNumber);
    }

    //    제품 정보 조회
    public PartnerProductDTO show(Long productNumber) {
        PartnerProductDTO partnerProductDTO = new PartnerProductDTO();
        partnerProductDTO.create(partnerProductDAO.findById(productNumber));
        return partnerProductDTO;
    }

    //    제품 전체 조회
    public List<ProductVO> showAll(PartnerCriteria partnerCriteria) {
        return partnerProductDAO.findAll(partnerCriteria);
    }

    //    제품 개수 조회
    public int getTotal() {
        return partnerProductDAO.findCountAll();
    }
}
