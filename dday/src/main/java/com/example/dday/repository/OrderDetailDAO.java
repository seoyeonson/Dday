package com.example.dday.repository;

import com.example.dday.domain.vo.OrderDetailVO;
import com.example.dday.mapper.OrderDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderDetailDAO {
    private final OrderDetailMapper orderDetailMapper;
    public List<OrderDetailVO> findByOrderNumber(Long orderNumber){ return orderDetailMapper.select(orderNumber); };
    public void save(OrderDetailVO orderDetailVO){ orderDetailMapper.insert(orderDetailVO); };
}
