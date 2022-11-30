package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberDTO {
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

    private AddressVO addressVO;

//    private String addressMain;
//    private String addressDetail;
//    private String addressReceivePerson;
//    private String addressReceivePhoneNumber;

    public void create(String memberId, String memberPw, String memberName, String memberEmail, String memberPhoneNumber, String memberGender, String memberType) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberPhoneNumber = memberPhoneNumber;
        this.memberGender = memberGender;
        this.memberType = memberType;
    }
}
