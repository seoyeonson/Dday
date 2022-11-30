package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CartVO {
    private Long memberNumber;
    private Long productNumber;
    private Integer cartCount;

    public void create(Long memberNumber, Long productNumber, Integer cartCount) {
        this.memberNumber = memberNumber;
        this.productNumber = productNumber;
        this.cartCount = cartCount;
    }
}
