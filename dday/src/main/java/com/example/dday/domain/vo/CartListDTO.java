package com.example.dday.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor @NoArgsConstructor
public class CartListDTO {
    private List<CartDTO> products;
    private Integer cartTotal;
}
