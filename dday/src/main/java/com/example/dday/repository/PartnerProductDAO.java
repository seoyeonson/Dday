package com.example.dday.repository;

import com.example.dday.domain.vo.PartnerCriteria;
import com.example.dday.domain.vo.PartnerProductDTO;
import com.example.dday.domain.vo.ProductVO;
import com.example.dday.mapper.PartnerProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PartnerProductDAO {
    private final PartnerProductMapper partnerProductMapper;

    //    제품 정보 추가
    public void save(PartnerProductDTO partnerProductDTO) {
        partnerProductMapper.insert(partnerProductDTO);
    }

    public void saveToday(PartnerProductDTO partnerProductDTO) {
        partnerProductMapper.insertToday(partnerProductDTO);
    }

    //    제품 정보 수정
    public void setProductVO(PartnerProductDTO partnerProductDTO) {
        partnerProductMapper.update(partnerProductDTO);
    }

    //    제품 정보 조회
    public ProductVO findById(Long productNumber) {
        return partnerProductMapper.select(productNumber);
    }

    //    제품 전체 조회
    public List<ProductVO> findAll(PartnerCriteria partnerCriteria) {
        return partnerProductMapper.selectAll(partnerCriteria);
    }

    //    제품 전체 개수
    public int findCountAll() {
        return partnerProductMapper.getTotal();
    }

    //    삭제
    public void remove(Long productNumber) {
        partnerProductMapper.delete(productNumber);
    }
}
