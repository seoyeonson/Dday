package com.example.dday.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Criteria {
    private int page;
    private int amount;

    public  Criteria create(int page, int amount) {
        this.page = page;
        this.amount = amount;
        return this;
    }

}
