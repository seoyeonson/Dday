package com.example.dday.service;

import com.example.dday.domain.vo.AddressVO;
import com.example.dday.domain.vo.MemberDTO;
import com.example.dday.domain.vo.MemberVO;
import com.example.dday.repository.AddressDAO;
import com.example.dday.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDAO memberDAO;
    private final MemberDTO memberDTO;
    private final AddressDAO addressDAO;

    @Transactional(rollbackFor = Exception.class)
    public void join(MemberDTO memberDTO){
        memberDAO.save(memberDTO);

        AddressVO addressVO = memberDTO.getAddressVO();
        addressVO.setMemberNumber(memberDTO.getMemberNumber());
        addressVO.setAddressReceivePerson(memberDTO.getMemberName());
        addressVO.setAddressReceivePhoneNumber(memberDTO.getMemberPhoneNumber());
        addressDAO.saveFirst(addressVO);
    };

    public MemberVO findByNumber(Long memberNumber){
        return memberDAO.findByNumber(memberNumber);
    };

    public void modify(MemberVO memberVO){
        memberDAO.setMemberVO(memberVO);
    };

    public void modifyMemberStatus(MemberVO memberVO){
        memberDAO.setMemberStatus(memberVO);
    };

    public int checkId(String memberId){
        return memberDAO.checkId(memberId);
    };

    public int checkEmail(String memberEmail){
        return memberDAO.checkEmail(memberEmail);
    };

    public MemberVO login(MemberVO memberVO){
        return Optional.ofNullable(memberDAO.login(memberVO)).orElse(new MemberVO());
    };

    public Long findLikeTotalByNumber(Long memberNumber){ return Optional.ofNullable(memberDAO.findLikeTotalByNumber(memberNumber)).orElse(0L); };
}
