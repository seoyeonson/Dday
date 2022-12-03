package com.example.dday.domain.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
@RequiredArgsConstructor
public class ProductCriteria {
    private int page;
    private int amount;
    // 상품번호 리뷰에서 사용
    private int productNumber;

    public ProductCriteria create(int page, int amount) {
        this.page = page;
        this.amount = amount;
        return this;
    }
    public ProductCriteria create2(int page, int amount, int productNumber) {
        this.page = page;
        this.amount = amount;
        this.productNumber = productNumber;
        return this;
    }



    public String getQueryString(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("page", this.page)
                .queryParam("amount", this.amount)
                .queryParam("productNumber", this.productNumber);
        return builder.toUriString();
    }
}
