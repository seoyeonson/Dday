package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PartnerDTO {
    //    PartnerVO
    private Long partnerNumber;
    private String partnerStoreName;
    private String partnerRegistrationNumber;
    private String partnerOwnerName;
    private String partnerOwnerEmail;
    private String partnerStoreAddress;
    private String partnerOwnerPhoneNumber;
    private String memberNumber;

    public void create(String partnerStoreName, String partnerRegistrationNumber, String partnerOwnerName, String partnerOwnerEmail, String partnerStoreAddress, String partnerOwnerPhoneNumber) {
        this.partnerStoreName = partnerStoreName;
        this.partnerRegistrationNumber = partnerRegistrationNumber;
        this.partnerOwnerName = partnerOwnerName;
        this.partnerOwnerEmail = partnerOwnerEmail;
        this.partnerStoreAddress = partnerStoreAddress;
        this.partnerOwnerPhoneNumber = partnerOwnerPhoneNumber;
    }

    //    ProductVO
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

}
