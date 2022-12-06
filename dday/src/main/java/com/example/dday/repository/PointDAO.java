package com.example.dday.repository;

import com.example.dday.domain.vo.PointVO;
import com.example.dday.mapper.PointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PointDAO {

    private final PointMapper pointMapper;

    //    전체 포인트
    public Integer findPointTotalByNumber(Long memberNumber){ return pointMapper.getPointTotal(memberNumber); };
    //    전체 포인트 리스트
    public List<PointVO> findAll(Long memberNumber){ return pointMapper.selectAll(memberNumber); };
    //    포인트 사용
    public void saveUse(PointVO pointVO){ pointMapper.insertUse(pointVO); };
    //    포인트 적립
    public void saveOrder(PointVO pointVO){ pointMapper.insertOrder(pointVO); };
}
