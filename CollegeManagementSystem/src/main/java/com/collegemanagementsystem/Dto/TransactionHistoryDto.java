package com.collegemanagementsystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistoryDto {
    private Long userId;
    private String name;
    private String semester;
    private Long mobileNo;
    private String paymentDoneBy;
    private String paymentDoneFor;
    private String transactionId;
    private String paymentType;
    private String registrationNo;
    private Double totalAmount;
    private List<FeeDivisionDto> feeDivision;


}