package com.example.dday.service;

import com.example.dday.domain.vo.AddressVO;
import com.example.dday.domain.vo.Criteria;
import com.example.dday.domain.vo.ManagerDTO;
import com.example.dday.domain.vo.ProductVO;
import com.example.dday.repository.AddressDAO;
import com.example.dday.repository.MainDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {
    private final MainDAO mainDAO;

    public List<ProductVO> showMainProduct() {
        return mainDAO.findMainProduct();
    }

}
