package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AddressVO {
    private Long addressNumber;
    private String addressMain;
    private String addressDetail;
    private String addressStatus;
    private String addressReceivePerson;
    private String addressReceivePhoneNumber;
    private Long memberNumber;

    public void create(String addressMain, String addressDetail, String addressStatus, String addressReceivePerson, String addressReceivePhoneNumber, Long memberNumber) {
        this.addressMain = addressMain;
        this.addressDetail = addressDetail;
        this.addressStatus = addressStatus;
        this.addressReceivePerson = addressReceivePerson;
        this.addressReceivePhoneNumber = addressReceivePhoneNumber;
        this.memberNumber = memberNumber;
    }

    public void create(String addressMain, String addressDetail, String addressReceivePerson, String addressReceivePhoneNumber, Long memberNumber) {
        this.addressMain = addressMain;
        this.addressDetail = addressDetail;
        this.addressReceivePerson = addressReceivePerson;
        this.addressReceivePhoneNumber = addressReceivePhoneNumber;
        this.memberNumber = memberNumber;
    }

    public void create(String addressMain, String addressDetail, String addressReceivePerson, String addressReceivePhoneNumber) {
        this.addressMain = addressMain;
        this.addressDetail = addressDetail;
        this.addressReceivePerson = addressReceivePerson;
        this.addressReceivePhoneNumber = addressReceivePhoneNumber;
    }
}
