package com.example.dday.mapper;

import com.example.dday.domain.vo.OrderDetailVO;
import com.example.dday.domain.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    public List<OrderDetailVO> select(Long orderNumber);
    public void insert(OrderDetailVO orderDetailVO);
}
