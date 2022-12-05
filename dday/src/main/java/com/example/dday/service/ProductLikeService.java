package com.example.dday.service;

import com.example.dday.domain.vo.CartVO;
import com.example.dday.domain.vo.ProductLikeVO;
import com.example.dday.domain.vo.ProductVO;
import com.example.dday.mapper.ProductLikeMapper;
import com.example.dday.repository.ProductLikeDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductLikeService {
    private final ProductLikeDAO productLikeDAO;
    private final ProductLikeMapper productLikeMapper;

    public List<ProductVO> list(Long memberNumber){ return productLikeDAO.findByMemberNumber(memberNumber); }
    public int findCountAll(Long memberNumber){ return productLikeDAO.findCountAll(memberNumber); };
    public void remove(Long productNumber, Long memberNumber){ productLikeDAO.remove(productNumber, memberNumber); };

    //    장바구니 상품 추가
    public void save(ProductLikeVO productLikeVO){
//        Integer cartCount = Optional.ofNullable(productLikeDAO.checkLike(productLikeVO)).orElse(0);
//        if(cartCount == 0){
            productLikeDAO.save(productLikeVO);
//        }
//        else {
//            productLikeDAO.setCount(productLikeVO);
//        }
    };
}
