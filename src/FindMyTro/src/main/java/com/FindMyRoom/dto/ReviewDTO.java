package com.FindMyRoom.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDTO {
    private long id;
    private String content;
    private Date createdDate;
}
