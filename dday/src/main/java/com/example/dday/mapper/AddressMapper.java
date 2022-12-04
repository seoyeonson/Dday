package com.example.dday.mapper;

import com.example.dday.domain.vo.AddressVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
//    회원가입시 추가
    public void insertFirst(AddressVO addressVO);
//    추가
    public void insert(AddressVO addressVO);
//    전체 조회
    public List<AddressVO> selectAll(Long memberNumber);
//    삭제
    public void delete(Long addressNumber);
//    기본배송지 -> 배송지 수정
    public void updateStatusNormal(Long memberNumber);
//    수정
    public void updateStatus(Long addressNumber, Long memberNumber);
}
