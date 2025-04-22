package com.FindMyRoom.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponseDTO {
    private long id;
    private String title;
    private String content;
    private String thumbnailURL;
    private String specialItem;
    private String media;
    private LocalDate createdDate;
    private Boolean status;
    private long view;
    private Long like;
    private Long share;
    private Set<String> comments;
}
