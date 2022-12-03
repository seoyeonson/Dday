package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class ReviewVO {
    private Long reviewNumber;
    private String reviewContent;
    private String reviewRegisterDate;
    private String reviewUpdateDate;
    private Long productNumber;
}
