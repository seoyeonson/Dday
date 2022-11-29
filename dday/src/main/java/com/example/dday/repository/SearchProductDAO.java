package com.example.dday.repository;

import com.example.dday.domain.vo.ProductVO;
import com.example.dday.mapper.SearchProductMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SearchProductDAO {
    @Qualifier("sqlSessionTemplate")
    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<ProductVO> selectSearchList(ProductVO productVO) throws Exception{
        return sqlSession.selectList("com.example.dday.mapper.SearchProductMapper.getProductList",productVO);
    }
}
