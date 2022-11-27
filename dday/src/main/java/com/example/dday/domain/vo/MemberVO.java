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
    private String memberBirth;
    private String memberSignupDate;
    private String memberType;
    private String memberStatus;
}
