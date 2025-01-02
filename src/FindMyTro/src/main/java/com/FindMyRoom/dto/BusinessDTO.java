package com.FindMyRoom.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessDTO {
    private long businessID;
    private float balance;
    private String permissionNumber;
}
