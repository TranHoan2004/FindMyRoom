package com.FindMyRoom.mapping;

import com.FindMyRoom.dto.PostDTO;
import com.FindMyRoom.model.Post;
import org.jetbrains.annotations.NotNull;

public class PostMapping {
    public PostDTO convert(@NotNull Post post) {
        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .address(post.getAddress())
                .thumbnailURL(post.getThumbnailURL())
                .specialItem(post.getSpecialItem())
                .media(post.getMedia())
                .createdDate(post.getCreatedDate())
                .status(post.getStatus())
                .view(post.getView())
                .build();
    }
}
