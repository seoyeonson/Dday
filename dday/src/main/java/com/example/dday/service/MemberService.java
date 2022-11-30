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
//        addressVO.setAddressMain(memberDTO.getAddressMain());
//        addressVO.setAddressDetail(memberDTO.getAddressDetail());
//        addressVO.setAddressReceivePerson(memberDTO.getMemberName());
//        addressVO.setAddressReceivePhoneNumber(memberDTO.getMemberPhoneNumber());
        addressVO.setMemberNumber(memberDTO.getMemberNumber());
//        memberDTO.setAddressVO(addressVO);
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

    public Long login(MemberVO memberVO){
        if(Optional.ofNullable(memberDAO.login(memberVO)).isPresent()){
            return memberDAO.login(memberVO);
        } else {
            return Long.valueOf(0);
        }
    };
}
