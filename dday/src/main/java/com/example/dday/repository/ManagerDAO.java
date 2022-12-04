package com.example.dday.repository;

import com.example.dday.domain.vo.Criteria;
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
    public List<ManagerDTO> findAll(Criteria criteria) {
        return  managerMapper.selectAll(criteria);
    }

    //회원검색
    public List<ManagerDTO> findAllBy(ManagerDTO managerDTO, Criteria criteria) throws Exception{
        return  managerMapper.selectAllBy("Manager.findAllby", criteria);
    }

    //회원 상세조회
    public MemberVO findMemberDetail(Long memberNumber) {
        return managerMapper.selectMemberDetail(memberNumber);
    }

    //전체 개수
    public int findCountAll() {
        return managerMapper.getTotal();
    }
}
