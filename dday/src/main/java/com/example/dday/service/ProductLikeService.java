package com.example.dday.service;

import com.example.dday.domain.vo.ProductVO;
import com.example.dday.repository.ProductLikeDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductLikeService {
    private final ProductLikeDAO productLikeDAO;

    public List<ProductVO> list(Long memberNumber){ return productLikeDAO.findByMemberNumber(memberNumber); }
    public int findCountAll(Long memberNumber){ return productLikeDAO.findCountAll(memberNumber); };
    public void remove(Long productNumber, Long memberNumber){ productLikeDAO.remove(productNumber, memberNumber); };
}
