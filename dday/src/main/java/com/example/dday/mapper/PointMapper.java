package com.example.dday.mapper;

import com.example.dday.domain.vo.PointVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PointMapper {
    //    전체 포인트
    public Long getPointTotal(Long memberNumber);
    //    전체 포인트 리스트
    public List<PointVO> selectAll(Long memberNumber);
}
