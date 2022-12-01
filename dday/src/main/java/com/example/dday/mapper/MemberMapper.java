package com.example.dday.mapper;

import com.example.dday.domain.vo.MemberDTO;
import com.example.dday.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
//    추가
    public void insert(MemberDTO memberDTO);
//    수정
    public void update(MemberVO memberVO);
//    조회
    public MemberVO select(Long memberNumber);
//    상태 수정
    public void updateStatus(MemberVO memberVO);
//    아이디 체크
    public int checkId(String memberId);
//    이메일 체크
    public int checkEmail(String memberEmail);
//    아이디/비밀번호 체크
    public MemberVO login(MemberVO memberVO);
}
