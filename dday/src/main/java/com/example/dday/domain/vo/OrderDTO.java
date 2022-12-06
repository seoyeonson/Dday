package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
public class OrderDTO {
    private OrderVO orderVO;
    private List<OrderDetailVO> orderDetailVO;
}
