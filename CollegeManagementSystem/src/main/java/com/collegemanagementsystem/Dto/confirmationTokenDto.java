package com.collegemanagementsystem.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class confirmationTokenDto {
    private String confirmationToken;
    private Date createdDate;
    private String userEmail;
}
