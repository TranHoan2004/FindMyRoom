package com.FindMyRoom.mapping;

import com.FindMyRoom.dto.response.PostResponseDTO;
import com.FindMyRoom.model.Post;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;

public class PostMapping {
    public PostResponseDTO convert(@NotNull Post post) {
        String filePath = new String(post.getThumbnailURL(), StandardCharsets.UTF_8);
        return PostResponseDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .thumbnailURL(filePath)
                .specialItem(post.getSpecialItem())
                .media(post.getMedia())
                .createdDate(post.getCreatedDate())
                .status(post.getStatus())
                .view(post.getView())
                .like(post.getLike())
                .share(post.getShare())
                .comments(post.getComments())
                .build();
    }
}
