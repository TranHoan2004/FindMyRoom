package com.FindMyRoom.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceDTO {
    private long id;
    private String name;
    private float price;
    private String content;
    private float salePrice;
    private Date startDate;
    private Date endDate;
    private int soldQuantity;
}
