package com.example.dday.service;

import com.example.dday.domain.vo.AddressVO;
import com.example.dday.domain.vo.MemberDTO;
import com.example.dday.domain.vo.MemberVO;
import com.example.dday.type.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

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
        memberDTO.create("efw1234", "1234", "이순신", "few1234@test.com", "01012341234", "남자", MemberType.NORMAL.label());
        addressVO.create("서울특별시 관악구 신림동", "1234", memberDTO.getMemberName(), memberDTO.getMemberPhoneNumber());
        memberDTO.setAddressVO(addressVO);
        memberService.join(memberDTO);
    }

    @Test
    public void findByNumberTest(){
        memberService.findByNumber(40L);
    };

    @Test
    public void modifyTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.create(memberService.findByNumber(40L));
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
        log.info("일치하는 아이디/비밀번호: " + Optional.ofNullable(memberService.login(memberVO)).map(MemberVO::getMemberName).orElse("로그인실패"));
    };

    @Test
    public void getLikeTotalTest(){
        log.info("찜한 상품 개수: " + memberService.findLikeTotalByNumber(26L));
    }


}