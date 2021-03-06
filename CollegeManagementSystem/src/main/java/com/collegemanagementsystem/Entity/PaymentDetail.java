package com.collegemanagementsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetail {
    @Id
    @GeneratedValue
    private Long paymentId;
    private String paymentType;
    private String paymentName;
    private Double amount;
    private String category;
}
