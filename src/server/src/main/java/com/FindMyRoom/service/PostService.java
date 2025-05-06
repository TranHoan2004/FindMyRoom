package com.FindMyRoom.service;

import com.FindMyRoom.dto.response.PostResponseDTO;
import org.springframework.data.domain.Page;

public interface PostService {
    Page<PostResponseDTO> getAllPostDTOsByPage(int page, int size);

    Page<PostResponseDTO> getAllFilteredPostDTOsByPage(int page, int size, String string);

    Page<PostResponseDTO> getAllPostByUserId(long id, int page, int size);
}
