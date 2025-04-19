package com.FindMyRoom.dto.request;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewRequestDTO {
    private long id;
    private String content;
    private Date createdDate;
}
