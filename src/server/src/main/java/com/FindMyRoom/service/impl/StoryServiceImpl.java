package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.response.StoryResponse;
import com.FindMyRoom.mapping.StoryMapping;
import com.FindMyRoom.model.Story;
import com.FindMyRoom.repository.StoryRepository;
import com.FindMyRoom.service.StoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StoryServiceImpl implements StoryService {
    StoryRepository repo;
    StoryMapping mapping;
    Logger logger = Logger.getLogger(StoryServiceImpl.class.getName());

    public StoryServiceImpl(StoryRepository repo) {
        this.repo = repo;
        this.mapping = new StoryMapping();
    }

    @Override
    public List<StoryResponse> getAllStoryDTOs() {
        logger.info("getAllStoryDTOs");
        List<StoryResponse> storyList = new ArrayList<>();
        List<Story> list = repo.findAll();
        if (list.isEmpty()) {
            throw new EntityNotFoundException("No Story");
        }
        list.forEach(n -> storyList.add(mapping.convert(n)));
        return storyList;
    }

    @Override
    public StoryResponse getStoryDTOById(Long id) {
        logger.info("getStoryDTOById");
        StoryResponse s = mapping.convert(repo.getById(id));
        if (s == null) {
            throw new EntityNotFoundException("No story with id = " + id);
        }
        return s;
    }
}
