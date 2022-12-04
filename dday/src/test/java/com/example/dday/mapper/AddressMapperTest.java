package com.example.dday.mapper;

import com.example.dday.domain.vo.AddressVO;
import com.example.dday.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AddressMapperTest {
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private MemberMapper memberMapper;

    //    회원가입시 추가
    @Test
    public void insertFirst(){
        AddressVO addressVO = new AddressVO();
        MemberVO memberVO = new MemberVO();
        memberVO = memberMapper.select(26L);
        addressVO.create("서울특별시 강남구 역삼동", "100","기본배송지", memberVO.getMemberName(), memberVO.getMemberPhoneNumber(), memberVO.getMemberNumber());
        addressMapper.insertFirst(addressVO);
    };

    //    추가
    @Test
    public void insertTest(){
        AddressVO addressVO = new AddressVO();
        MemberVO memberVO = new MemberVO();
        memberVO = memberMapper.select(26L);
        addressVO.create("서울특별시 강남구 역삼동", "100", memberVO.getMemberName(), memberVO.getMemberPhoneNumber(), memberVO.getMemberNumber());
        addressMapper.insert(addressVO);
    };

    //    전체 조회
    @Test
    public void selectAllTest(){
        addressMapper.selectAll(81L);
    };

//    //    삭제
    @Test
    public void deleteTest(){
        addressMapper.delete(5L);
    };

    //    기본배송지 -> 배송지 수정
    @Test
    public void updateStatusNormalTest(){
        AddressVO addressVO = new AddressVO();
        addressMapper.updateStatusNormal(26L);
    };

    //    수정
    @Test
    public void updateStatusTest(){
        AddressVO addressVO = new AddressVO();
        addressMapper.updateStatus(26L, 7L);
    };
}