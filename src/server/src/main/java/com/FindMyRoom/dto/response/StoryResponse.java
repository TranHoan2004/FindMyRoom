package com.FindMyRoom.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoryResponse {
    String encodedId;
    String link;
    String thumbnailImg;
    String storyType;
}