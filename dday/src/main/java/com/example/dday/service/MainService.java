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

    public List<ProductVO> showMainProduct2() { return mainDAO.findMainProduct2();}

    public List<ProductVO> showMainProduct3() { return mainDAO.findMainProduct3();}
    public List<ProductVO> showMainProduct4() { return mainDAO.findMainProduct4();}
    public List<ProductVO> showMainProduct5() { return mainDAO.findMainProduct5();}
    public List<ProductVO> showMainProduct6() { return mainDAO.findMainProduct6();}

}
