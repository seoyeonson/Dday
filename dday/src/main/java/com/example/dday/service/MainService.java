package com.example.dday.service;

import com.example.dday.domain.vo.ProductVO;
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
