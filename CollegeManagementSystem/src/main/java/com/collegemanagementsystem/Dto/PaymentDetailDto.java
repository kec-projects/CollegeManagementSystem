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
    @Id
    @GeneratedValue
    private Long paymentId;
    private String paymentType;
    private String paymentName;
    private Double amount;
    private String category;
}
