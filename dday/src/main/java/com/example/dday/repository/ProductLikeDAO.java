package com.example.dday.repository;

import com.example.dday.domain.vo.CartVO;
import com.example.dday.domain.vo.ProductLikeVO;
import com.example.dday.domain.vo.ProductVO;
import com.example.dday.mapper.ProductLikeMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductLikeDAO {
    private final ProductLikeMapper productLikeMapper;

    public List<ProductVO> findByMemberNumber(Long memberNumber){ return productLikeMapper.selectAll(memberNumber); };
    public int findCountAll(Long memberNumber){ return productLikeMapper.getTotal(memberNumber); };
    public void remove(Long productNumber, Long memberNumber){ productLikeMapper.delete(productNumber, memberNumber);};

    //    찜목록에 존재하는 상품인지 체크
//    public Integer checkLike(ProductLikeVO productLikeVO){
//        return productLikeMapper.checkLike(productLikeVO);
//    }
    //    찜목록 상품 추가
    public void save(ProductLikeVO productLikeVO){ productLikeMapper.insert(productLikeVO); }
//    //    찜목록 상품 개수 수정
//    public void setCount(ProductLikeVO productLikeVO){ productLikeMapper.updateCount(productLikeVO); }
}
