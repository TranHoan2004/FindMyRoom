package com.FindMyRoom.mapping;

import com.FindMyRoom.dto.StoryDTO;
import com.FindMyRoom.model.Story;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;

public class StoryMapping {
    public StoryDTO convert(@NotNull Story story) {
        String filePath = new String(story.getThumbnailImg(), StandardCharsets.UTF_8);

        return StoryDTO.builder()
                .id(story.getId())
                .title(story.getTitle())
                .description(story.getDescription())
                .link(story.getLink())
                .storyType(story.getType().getName())
                .thumbnailImg(filePath)
                .build();
    }
}
