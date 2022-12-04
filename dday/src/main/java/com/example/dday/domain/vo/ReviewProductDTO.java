package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReviewProductDTO {
    private Long reviewNumber;
    private String reviewContent;
    private String reviewRegistDate;
    private String reviewUpdateDate;
    private Long productNumber;
    private Long orderDetailNumber;
    private String productName;

}
