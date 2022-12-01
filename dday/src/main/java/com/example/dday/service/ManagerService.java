package com.example.dday.service;

import com.example.dday.domain.vo.ManagerDTO;
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

    public List<ManagerDTO> showAll() {
        return managerDAO.findAll();
    }

}
