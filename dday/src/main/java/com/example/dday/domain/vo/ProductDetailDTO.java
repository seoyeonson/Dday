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
    private String productName;
    private String productCategory;
    private Long productPrice;
    private Long productStock;
    private String productManufactureDate;
    private String productExpirationDate;
    private String productOnelineInformation;
    private String productInformation;
    private String productThumbnailName;
    private String productMainImageName;
    private String productRegistDate;
    private String productModifyDate;
    private String productTodaySale;
    private String productOpenHours;
    private Long productSalePercent;
    private Long productViewCount;
    private Long productSalePrice;



}
