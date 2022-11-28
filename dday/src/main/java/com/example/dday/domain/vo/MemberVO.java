package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberVO {
    private Long memberNumber;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberEmail;
    private String memberPhoneNumber;
    private String memberGender;
    private String memberSignupDate;
    private String memberType;
    private String memberStatus;

    public void create(MemberVO memberVO) {
        this.memberNumber = memberVO.getMemberNumber();
        this.memberId = memberVO.getMemberId();
        this.memberPw = memberVO.getMemberPw();
        this.memberName = memberVO.getMemberName();
        this.memberEmail = memberVO.getMemberEmail();
        this.memberPhoneNumber = memberVO.getMemberPhoneNumber();
        this.memberGender = memberVO.getMemberGender();
        this.memberType = memberVO.getMemberType();
    }

    public void create(String memberId, String memberPw, String memberName, String memberEmail, String memberPhoneNumber, String memberGender, String memberType) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberPhoneNumber = memberPhoneNumber;
        this.memberGender = memberGender;
        this.memberType = memberType;
    }

    public void create(String memberPw, String memberName, String memberEmail, String memberPhoneNumber, String memberGender) {
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberPhoneNumber = memberPhoneNumber;
        this.memberGender = memberGender;
    }
}
