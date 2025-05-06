package com.FindMyRoom.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostResponseDTO {
    String id;
    String title;
    String content;
    String thumbnailURL;
    String specialItem;
    String media;
    LocalDate createdDate;
    Boolean status;
    long view;
    Long like;
    Long share;
    Set<String> comments;
}
