package com.collegemanagementsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistory {
  private Long userId;
  private String name;
  private String semester;
  private Date date;
  private Time time;
  private Long mobileNo;
  private String paymentDoneBy;
  private String paymentDoneFor;
  @Id
  private String transactionId;
  private String paymentType;
  private String registrationNo;
  private Double totalAmount;


}
