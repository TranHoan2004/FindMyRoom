package com.FindMyRoom.dto.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResponseDTO {
    private long id;
    private String content;
    private Date createdDate;
}
