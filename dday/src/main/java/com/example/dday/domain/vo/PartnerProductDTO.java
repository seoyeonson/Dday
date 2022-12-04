package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PartnerProductDTO {
    Long productNumber;
    String productName;
    String productCategory;
    Long productPrice;
    Long productStock;
    String productManufactureDate;
    String productExpirationDate;
    String productOnelineInformation;
    String productInformation;
    String productThumbnailName;
    String productMainImageName;
    String productRegistDate;
    String productModifyDate;
    String productTodaySale;
    String productOpenHours;
    Long productSalePercent;
    Long productViewCount;
    Long productSalePrice;

    public void create(ProductVO productVO) {
        this.productName = productVO.getProductName();
        this.productCategory = productVO.getProductCategory();
        this.productPrice = productVO.getProductPrice();
        this.productStock = productVO.getProductStock();
        this.productManufactureDate = productVO.getProductManufactureDate();
        this.productExpirationDate = productVO.getProductExpirationDate();
        this.productOnelineInformation = productVO.getProductOnelineInformation();
        this.productInformation = productVO.getProductInformation();
        this.productThumbnailName = productVO.getProductThumbnailName();
        this.productMainImageName = productVO.getProductMainImageName();
        this.productTodaySale = productVO.getProductTodaySale();
        this.productSalePercent = productVO.getProductSalePercent();
    }

    public void create(String productName, String productCategory, Long productPrice, Long productStock, String productManufactureDate, String productExpirationDate, String productOnelineInformation, String productInformation, String productThumbnailName, String productMainImageName, String productTodaySale, Long productSalePercent) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productManufactureDate = productManufactureDate;
        this.productExpirationDate = productExpirationDate;
        this.productOnelineInformation = productOnelineInformation;
        this.productInformation = productInformation;
        this.productThumbnailName = productThumbnailName;
        this.productMainImageName = productMainImageName;
        this.productTodaySale = productTodaySale;
        this.productSalePercent = productSalePercent;
//        this.productViewCount = productViewCount;
    }
}
