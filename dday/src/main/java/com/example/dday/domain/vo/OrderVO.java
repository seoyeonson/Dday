package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class OrderVO {
    private Long orderNumber;
    private String orderDate;
    private Integer orderTotalAmount;
    private String orderDeliveryDate;
    private String orderDeliveryAddress;
    private String orderShippingPlace;
    private Long memberNumber;
}
