package com.example.dday.service;

import com.example.dday.domain.vo.OrderDetailVO;
import com.example.dday.repository.OrderDetailDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailService {
    private final OrderDetailDAO orderDetailDAO;
    public List<OrderDetailVO> findByOrderNumber(Long orderNumber){ return orderDetailDAO.findByOrderNumber(orderNumber); };
    public void save(OrderDetailVO orderDetailVO){ orderDetailDAO.save(orderDetailVO); };
}
