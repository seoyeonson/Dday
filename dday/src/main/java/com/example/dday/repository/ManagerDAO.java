package com.example.dday.repository;

import com.example.dday.domain.vo.ManagerDTO;
import com.example.dday.domain.vo.MemberDTO;
import com.example.dday.domain.vo.MemberVO;
import com.example.dday.mapper.ManagerMapper;
import com.example.dday.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ManagerDAO {
    private final ManagerMapper managerMapper;

    //전체 조회
    public List<ManagerDTO> findAll() {
        return  managerMapper.selectAll();
    }

}
