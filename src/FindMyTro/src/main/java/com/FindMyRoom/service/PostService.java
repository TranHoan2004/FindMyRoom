package com.FindMyRoom.service;

import com.FindMyRoom.dto.PostDTO;
import org.springframework.data.domain.Page;

public interface PostService {
    Page<PostDTO> getAllPostDTOsByPage(int page, int size) throws Exception;

    Page<PostDTO> getAllFilteredPostDTOsByPage(int page, int size, String string) throws Exception;
}
