package com.FindMyRoom.mapping;

import com.FindMyRoom.controller.utils.URLIdEncoder;
import com.FindMyRoom.dto.response.StoryResponse;
import com.FindMyRoom.model.Story;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;

public class StoryMapping {
    public StoryResponse convert(@NotNull Story story) {
        String filePath = new String(story.getThumbnailImg(), StandardCharsets.UTF_8);

        return StoryResponse.builder()
                .encodedId(URLIdEncoder.encodeId(story.getId()))
                .link(story.getLink())
                .storyType(story.getType().getName())
                .thumbnailImg(filePath)
                .build();
    }
}
