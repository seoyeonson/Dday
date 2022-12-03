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

    public List<ManagerDTO> showAllBy(String memberId, Criteria criteria) {
        return managerDAO.findAllBy(memberId, criteria);

    }

    public MemberVO showMemberDetail(Long memberNumber) {
        return managerDAO.findMemberDetail(memberNumber);
    }

}
