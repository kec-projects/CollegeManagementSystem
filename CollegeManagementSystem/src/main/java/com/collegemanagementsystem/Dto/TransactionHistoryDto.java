package com.collegemanagementsystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistoryDto {
    @Id
    private Long userId;
    private String name;
    private String semester;
    private Timestamp date;
    private Long mobileNo;
    private String paymentDoneBy;
    private String paymentDoneFor;
    private String transactionId;
    private String paymentType;
    private String registrationNo;
    private Long totalAmount;
    private List<FeeDivisionDto> feeDivision;

}