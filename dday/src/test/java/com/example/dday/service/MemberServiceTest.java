package com.example.dday.service;

import com.example.dday.domain.vo.AddressVO;
import com.example.dday.domain.vo.MemberDTO;
import com.example.dday.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Test
    public void signup(){
        MemberDTO memberDTO = new MemberDTO();
        AddressVO addressVO = new AddressVO();
        memberDTO.create("lss1234", "1234", "이순신", "lss1234@test.com", "01012341234", "남자", "파트너회원");
        memberDTO.setAddressMain("서울특별시 관악구 신림동");
        memberDTO.setAddressDetail("1234");
        memberDTO.setAddressReceivePerson(memberDTO.getMemberName());
        memberDTO.setAddressReceivePhoneNumber(memberDTO.getMemberPhoneNumber());
        memberService.join(memberDTO);
    }

    @Test
    public void findByNumberTest(){
        memberService.findByNumber(35L);
    };

    @Test
    public void modifyTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.create(memberService.findByNumber(35L));
        memberVO.setMemberPw("1111");
        memberService.modify(memberVO);
    };

    @Test
    public void modifyMemberStatusTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberNumber(35L);
        memberVO.setMemberStatus("탈퇴");
        memberService.modifyMemberStatus(memberVO);
    };

    @Test
    public void checkIdTest(){
        memberService.checkId("test");
    };

    @Test
    public void checkEmailTest(){
        memberService.checkEmail("test2@test.com");
    };

    @Test
    public void loginTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberId("test");
        memberVO.setMemberPw("test");
        memberService.login(memberVO);
    };
}