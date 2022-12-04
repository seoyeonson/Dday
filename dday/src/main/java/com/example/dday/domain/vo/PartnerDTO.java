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
    private String partnerRegistrationNumber1;
    private String partnerRegistrationNumber2;
    private String partnerRegistrationNumber3;
    private String partnerOwnerName;
    private String partnerOwnerEmail;
    private String partnerStorePostcode;
    private String partnerStoreAddress;
    private String partnerStoreDetailedAddress;
    private String partnerOwnerPhoneNumber;
    private String memberNumber;

    public void create(PartnerVO partnerVO) {
        this.partnerNumber = partnerVO.getPartnerNumber();
        this.partnerStoreName = partnerVO.getPartnerStoreName();
        this.partnerRegistrationNumber1 = partnerVO.getPartnerRegistrationNumber1();
        this.partnerRegistrationNumber2 = partnerVO.getPartnerRegistrationNumber2();
        this.partnerRegistrationNumber3 = partnerVO.getPartnerRegistrationNumber3();
        this.partnerOwnerName = partnerVO.getPartnerOwnerName();
        this.partnerOwnerEmail = partnerVO.getPartnerOwnerEmail();
        this.partnerStorePostcode = partnerVO.getPartnerStorePostcode();
        this.partnerStoreAddress = partnerVO.getPartnerStoreAddress();
        this.partnerStoreDetailedAddress = partnerVO.getPartnerStoreDetailedAddress();
        this.partnerOwnerPhoneNumber = partnerVO.getPartnerOwnerPhoneNumber();
    }

    public void create(String partnerStoreName, String partnerRegistrationNumber1, String partnerRegistrationNumber2, String partnerRegistrationNumber3, String partnerOwnerName, String partnerOwnerEmail, String partnerStorePostcode, String partnerStoreAddress, String partnerStoreDetailedAddress, String partnerOwnerPhoneNumber) {
        this.partnerStoreName = partnerStoreName;
        this.partnerRegistrationNumber1 = partnerRegistrationNumber1;
        this.partnerRegistrationNumber2 = partnerRegistrationNumber2;
        this.partnerRegistrationNumber3 = partnerRegistrationNumber3;
        this.partnerOwnerName = partnerOwnerName;
        this.partnerOwnerEmail = partnerOwnerEmail;
        this.partnerStorePostcode = partnerStorePostcode;
        this.partnerStoreAddress = partnerStoreAddress;
        this.partnerStoreDetailedAddress = partnerStoreDetailedAddress;
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
