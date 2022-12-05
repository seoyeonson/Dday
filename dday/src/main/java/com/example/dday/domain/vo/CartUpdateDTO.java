package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CartUpdateDTO {
    private Long memberNumber;
    private Long productNumber;
    private Integer cartCount;
    private String calcType;
}
