package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ProductVO {
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
    private Long memberNumber;
    private Long productColNum;

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

    public void create2(String productName, String productCategory, Long productPrice, Long productStock, String productManufactureDate, String productExpirationDate, String productOnelineInformation, String productInformation, String productThumbnailName, String productMainImageName, String productTodaySale, String productOpenHours, Long productSalePercent) {
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
        this.productOpenHours = productOpenHours;
        this.productSalePercent = productSalePercent;
//        this.productViewCount = productViewCount;

    }

}

