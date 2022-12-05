package com.example.dday.mapper;

import com.example.dday.domain.vo.Criteria;
import com.example.dday.domain.vo.ManagerDTO;
import com.example.dday.domain.vo.MemberVO;
import org.apache.catalina.Manager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManagerMapper {

 //목록 조회
 public List<ManagerDTO> selectAll(Criteria criteria);

 //목록 조회
 public List<ManagerDTO> selectAllBy(String keyword, Criteria criteria);

 //회원 상세 조회
 public MemberVO selectMemberDetail(Long memberNumber);

 //전체 개수
 public int getTotal();
}
