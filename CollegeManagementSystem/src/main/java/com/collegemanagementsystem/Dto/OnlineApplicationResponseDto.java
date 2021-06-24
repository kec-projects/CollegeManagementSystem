package com.collegemanagementsystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OnlineApplicationResponseDto {
    private Long userId;
    private Date approvedDate;
    private String purpose;
    private String certificateType;
    private String status;
}
