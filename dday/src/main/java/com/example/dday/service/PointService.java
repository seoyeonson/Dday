package com.example.dday.service;

import com.example.dday.domain.vo.PointVO;
import com.example.dday.repository.PointDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PointService {
    private final PointDAO pointDAO;

    public Long findPointTotalByNumber(Long memberNumber){ return Optional.ofNullable(pointDAO.findPointTotalByNumber(memberNumber)).orElse(0L); };
    public List<PointVO> showAll(Long memberNumber){ return pointDAO.findAll(memberNumber); };
}
