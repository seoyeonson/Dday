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
        memberDTO.create("efw1234", "1234", "이순신", "few1234@test.com", "01012341234", "남자", "파트너회원");
        addressVO.create("서울특별시 관악구 신림동", "1234", memberDTO.getMemberName(), memberDTO.getMemberPhoneNumber());
        memberDTO.setAddressVO(addressVO);
        memberService.join(memberDTO);
    }

    @Test
    public void findByNumberTest(){
        memberService.findByNumber(65L);
    };

    @Test
    public void modifyTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.create(memberService.findByNumber(65L));
        memberVO.setMemberPw("1111");
        memberService.modify(memberVO);
    };

    @Test
    public void modifyMemberStatusTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberNumber(65L);
        memberVO.setMemberStatus("탈퇴");
        memberService.modifyMemberStatus(memberVO);
    };

    @Test
    public void checkIdTest(){
        memberService.checkId("efw1234");
    };

    @Test
    public void checkEmailTest(){
        memberService.checkEmail("1234@test.com");
    };

    @Test
    public void loginTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberId("test");
        memberVO.setMemberPw("test");
        log.info("일치하는 아이디/비밀번호: " + memberService.login(memberVO));
    };
}