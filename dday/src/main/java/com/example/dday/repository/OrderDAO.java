package com.example.dday.repository;

import com.example.dday.domain.vo.OrderVO;
import com.example.dday.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderDAO {
    private final OrderMapper orderMapper;

    public List<OrderVO> findByMemberNumber(Long memberNumber){ return orderMapper.select(memberNumber); };
    public void save(OrderVO orderVO){ orderMapper.insert(orderVO);};
}
