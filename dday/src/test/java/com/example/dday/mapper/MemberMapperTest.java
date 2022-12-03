package com.example.dday.mapper;

import com.example.dday.domain.vo.MemberDTO;
import com.example.dday.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Member;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MemberMapperTest {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void insertTest(){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.create("test2", "test", "테스트", "test3@test.com", "01012341234", "남자", "일반회원");
        memberMapper.insert(memberDTO);
        log.info("memberNumber: " + memberDTO.getMemberNumber());
    }

    @Test
    public void updateTest(){
        MemberVO memberVO = new MemberVO();
        memberVO = memberMapper.select(26L);
        memberVO.setMemberName("테스트수정2");
        memberMapper.update(memberVO);
    }

    @Test
    public void updateStatusTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberNumber(26L);
        memberVO.setMemberStatus("탈퇴");
        memberMapper.updateStatus(memberVO);
    }

    @Test
    public void checkIdTest(){
        log.info("Id Check: " + (memberMapper.checkId("test2") == 0 ? "false" : "true"));
    }

    @Test
    public void checkEmailTest(){
        log.info("Email Check: " + (memberMapper.checkEmail("test@test.com") == 0 ? "false" : "true"));
    }

    @Test
    public void loginTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberId("test");
        memberVO.setMemberPw("21");
        log.info("login Ok: " + (memberMapper.login(memberVO) == null ? "false" : "Ok"));
    }

    @Test
    public void getLikeTotalTest(){
        log.info("찜한 상품 개수: " + memberMapper.getLikeTotal(26L));
    }

}