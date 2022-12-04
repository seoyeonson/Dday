package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class ProductDetailDTO {
    // 파트너 정보
    private Long partnerNumber;
    private Long memberNumber;
    private String partnerStoreName;
    private String partnerOwnerName;
    private String partnerOwnerEmail;
    private String partnerStoreAddress;
    private String partnerOwnerPhoneNumber;

    // 상품 정보
    private Long productNumber;




}
