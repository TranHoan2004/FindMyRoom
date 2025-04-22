package com.FindMyRoom.service;

import com.FindMyRoom.dto.StoryDTO;

import java.util.List;

public interface StoryService {
    List<StoryDTO> getAllStoryDTOs() throws Exception;

    StoryDTO getStoryDTOById(Long id) throws Exception;
}
