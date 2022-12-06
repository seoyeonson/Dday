package com.example.dday.mapper;

import com.example.dday.domain.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    public List<OrderVO> select(Long memberNumber);
    public void insert(OrderVO orderVO);
}
