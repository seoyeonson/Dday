package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class OrderVO {
    Long orderNumber;
    String orderDate;
    Integer orderTotalAmount;
    String orderDeliveryDate;
    String orderDeliveryAddress;
    String orderShippingPlace;
    Long memberNumber;
}
