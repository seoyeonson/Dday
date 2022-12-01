package com.example.dday.mapper;

import com.example.dday.domain.vo.ManagerDTO;
import com.example.dday.domain.vo.MemberVO;
import org.apache.catalina.Manager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManagerMapper {

 //목록 조회
 public List<ManagerDTO> selectAll();

}
