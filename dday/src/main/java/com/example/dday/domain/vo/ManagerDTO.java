package com.example.dday.domain.vo;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor

public class ManagerDTO {

    private Long memberNumber;
    private String memberName;
    private String memberId;
    private String memberSignupDate;
    private Long pointPrice;
    private Long orderNumber;
    private Long orderTotalAmount;

    

}
