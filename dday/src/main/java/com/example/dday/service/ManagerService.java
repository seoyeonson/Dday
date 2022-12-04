package com.example.dday.service;

import com.example.dday.domain.vo.Criteria;
import com.example.dday.domain.vo.ManagerDTO;
import com.example.dday.domain.vo.MemberVO;
import com.example.dday.repository.ManagerDAO;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Manager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private  final ManagerDAO managerDAO;

    public List<ManagerDTO> showAll(Criteria criteria) {
        return managerDAO.findAll(criteria);
    }

    //검색
    public List<ManagerDTO> showAllBy(ManagerDTO managerDTO Criteria criteria) throws Exception{
        return managerDAO.findAllBy(managerDTO, criteria);

    }

    public MemberVO showMemberDetail(Long memberNumber) {
        return managerDAO.findMemberDetail(memberNumber);
    }

    //전 체 개수
    public int getTotal() {
        return managerDAO.findCountAll();
    }
}
