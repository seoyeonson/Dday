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

    //멤버 리스트 전체보기
    public List<ManagerDTO> showAll(Criteria criteria) {
        return managerDAO.findAll(criteria);
    }

<<<<<<< Updated upstream
    //검색
//    public List<ManagerDTO> showAllBy(ManagerDTO managerDTO Criteria criteria) throws Exception{
//        return managerDAO.findAllBy(managerDTO, criteria);
//
//    }

=======
    //멤버 검색
    public List<ManagerDTO> showAllBy(String keyword, Criteria criteria) {
        return managerDAO.findAllBy(keyword, criteria);

    }
    //멤버 상세보기
>>>>>>> Stashed changes
    public MemberVO showMemberDetail(Long memberNumber) {
        return managerDAO.findMemberDetail(memberNumber);
    }

    // 페이지 전체개수
    public int getTotal() {
        return managerDAO.findCountAll();
    }
}
