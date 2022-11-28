package com.example.dday.repository;

import com.example.dday.domain.vo.MemberDTO;
import com.example.dday.domain.vo.MemberVO;
import com.example.dday.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;
    //    추가
    public void save(MemberDTO memberDTO){ memberMapper.insert(memberDTO); };
    //    수정
    public void setMemberVO(MemberVO memberVO){ memberMapper.update(memberVO); };
    //    조회
    public MemberVO findByNumber(Long memberNumber){ return memberMapper.select(memberNumber); };
    //    상태 수정
    public void setMemberStatus(MemberVO memberVO){ memberMapper.updateStatus(memberVO); };
    //    아이디 체크
    public int checkId(String memberId){ return memberMapper.checkId(memberId); };
    //    이메일 체크
    public int checkEmail(String memberEmail){ return  memberMapper.checkEmail(memberEmail); };

    //    아이디/비밀번호 체크
    public Long login(MemberVO memberVO){ return memberMapper.login(memberVO); };
}
