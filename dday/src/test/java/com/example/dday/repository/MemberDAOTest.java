package com.example.dday.repository;

import com.example.dday.domain.vo.MemberDTO;
import com.example.dday.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class MemberDAOTest {
    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void saveTest(){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.create("test3", "test", "테스트", "test3@test.com", "01012341234", "남자", "일반회원");
        memberDAO.save(memberDTO);
    }

    @Test
    public void updateTest(){
        MemberVO memberVO = new MemberVO();
        memberVO = memberDAO.findByNumber(24L);
        memberVO.setMemberName("테스트수정");
        memberVO.setMemberNumber(24L);
        memberDAO.setMemberVO(memberVO);
    }

    @Test
    public void updateStatusTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberNumber(24L);
        memberVO.setMemberStatus("탈퇴");
        memberDAO.setMemberStatus(memberVO);
    }

    @Test
    public void checkIdTest(){
        log.info("Id Check: " + (memberDAO.checkId("test2") == 0 ? "false" : "true"));
    }

    @Test
    public void checkEmailTest(){
        log.info("Email Check: " + (memberDAO.checkEmail("test@test.com") == 0 ? "false" : "true"));
    }

    @Test
    public void loginTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberId("test");
        memberVO.setMemberPw("test");
        log.info("login Ok: " + (Optional.ofNullable(memberDAO.login(memberVO)).map(MemberVO::getMemberName).orElse("로그인실패")));
    }
}