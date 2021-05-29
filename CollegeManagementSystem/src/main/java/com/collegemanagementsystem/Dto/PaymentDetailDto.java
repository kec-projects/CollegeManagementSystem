package com.collegemanagementsystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetailDto {

    private String paymentType;
    private String paymentName;
    private Long amount;
    private String category;
}

