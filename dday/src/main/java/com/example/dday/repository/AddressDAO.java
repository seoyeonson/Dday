package com.example.dday.repository;

import com.example.dday.domain.vo.AddressVO;
import com.example.dday.mapper.AddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AddressDAO {
    private final AddressMapper addressMapper;
    //    회원가입시 추가
    public void saveFirst(AddressVO addressVO){ addressMapper.insertFirst(addressVO); };
    //    추가
    public void save(AddressVO addressVO){ addressMapper.insert(addressVO); };
    //    전체 조회
    public List<AddressVO> findAll(Long memberNumber){ return addressMapper.selectAll(memberNumber); };
    //    삭제
    public void remove(Long addressNumber){ addressMapper.delete(addressNumber); };
    //    기본배송지 -> 배송지 수정
    public void setStatusNormal(Long memberNumber){ addressMapper.updateStatusNormal(memberNumber);};
    //    수정
    public void setStatus(Long addressNumber, Long memberNumber){ addressMapper.updateStatus(addressNumber, memberNumber); };
}
