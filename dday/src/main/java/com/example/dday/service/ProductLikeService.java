package com.example.dday.service;

import com.example.dday.domain.vo.ProductLikeVO;
import com.example.dday.domain.vo.ProductVO;
import com.example.dday.mapper.ProductLikeMapper;
import com.example.dday.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductLikeService {
    private ProductLikeMapper productLikeMapper;

    public String clickLikeButton(ProductLikeVO productLikeVO){
        try{
            productLikeMapper.insert(productLikeVO);
            return "selected";
        }catch(DataAccessException dae){
            productLikeMapper.delete(productLikeVO);
            return "unselected";
        }
    }
}
