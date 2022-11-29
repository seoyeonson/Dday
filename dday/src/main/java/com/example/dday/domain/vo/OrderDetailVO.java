package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class OrderDetailVO {
    private Long orderDetailNumber;
    private Integer orderDetailCount;
    private Integer orderDetailPrice;
    private String orderDetailDeliveryState;
    private String orderDetailReview;
    private String orderDetailReviewImage;
    private Long orderNumber;
    private Long productNumber;
}
