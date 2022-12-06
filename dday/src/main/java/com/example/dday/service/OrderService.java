package com.example.dday.service;

import com.example.dday.domain.vo.OrderDTO;
import com.example.dday.domain.vo.OrderVO;
import com.example.dday.mapper.OrderMapper;
import com.example.dday.repository.OrderDAO;
import com.example.dday.repository.OrderDetailDAO;
import jdk.jfr.TransitionTo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDAO orderDAO;
    private final OrderDetailDAO orderDetailDAO;

    public List<OrderVO> findByMemberNumber(Long memberNumber){ return orderDAO.findByMemberNumber(memberNumber); };

    @Transactional(rollbackFor = Exception.class)
    public void save(OrderVO orderVO){
        orderDAO.save(orderVO);
    };
}
