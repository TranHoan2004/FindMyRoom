package com.FindMyRoom.dto.request;

import com.FindMyRoom.model.utils.StoryType;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StoryRequestDTO {
    private Long id;
    private String title;
    private StoryType storyType;
    private String link;
    private String description;
    private String thumbnailImg;
}
