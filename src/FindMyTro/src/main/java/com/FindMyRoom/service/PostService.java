package com.FindMyRoom.service;

import com.FindMyRoom.dto.response.PostResponseDTO;
import org.springframework.data.domain.Page;

public interface PostService {
    Page<PostResponseDTO> getAllPostDTOsByPage(int page, int size) throws Exception;

    Page<PostResponseDTO> getAllFilteredPostDTOsByPage(int page, int size, String string) throws Exception;
}
