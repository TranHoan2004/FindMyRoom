package com.FindMyRoom.service;

import com.FindMyRoom.dto.response.StoryResponse;

import java.util.List;

public interface StoryService {
    List<StoryResponse> getAllStoryDTOs();

    StoryResponse getStoryDTOById(Long id);
}
