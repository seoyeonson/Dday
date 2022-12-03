package com.example.dday.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PointVO {
    private Long pointNumber;
    private Long memberNumber;
    private Integer pointRemain;
    private Integer pointPrice;
    private String pointContent;
    private String pointDate;
    private String pointEndDate;
    private String pointType;

}
