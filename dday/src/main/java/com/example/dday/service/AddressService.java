package com.example.dday.service;

import com.example.dday.domain.vo.AddressVO;
import com.example.dday.repository.AddressDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressDAO addressDAO;

    //    추가
    public void save(AddressVO addressVO){ addressDAO.save(addressVO); };
    //    전체 조회
    public List<AddressVO> findAll(Long memberNumber){ return addressDAO.findAll(memberNumber); };
    //    삭제
    public void remove(Long addressNumber){ addressDAO.remove(addressNumber); };
    //    기본배송지 -> 배송지 수정
    public void setStatusNormal(AddressVO addressVO){ addressDAO.setStatusNormal(addressVO);};
    //    수정
    public void setStatus(AddressVO addressVO){ addressDAO.setStatus(addressVO); };

}
