package com.FindMyRoom.dto.response;

import com.FindMyRoom.model.utils.StoryType;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StoryResponseDTO {
    private Long id;
    private String title;
    private StoryType storyType;
    private String link;
    private String description;
    private String thumbnailImg;
}
