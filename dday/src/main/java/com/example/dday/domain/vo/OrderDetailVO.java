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
    private Long orderDetailPrice;
    private String orderDetailDeliveryState;
    private Long orderDetailTotalAmount;
    private Long orderNumber;
    private Long productNumber;
}
