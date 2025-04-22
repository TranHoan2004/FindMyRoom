package com.FindMyRoom.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StoryDTO {
    private Long id;
    private String title;
    private String storyType;
    private String link;
    private String description;
    private String thumbnailImg;
}
