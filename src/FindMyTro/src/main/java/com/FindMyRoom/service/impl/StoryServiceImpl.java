package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.StoryDTO;
import com.FindMyRoom.mapping.StoryMapping;
import com.FindMyRoom.model.Story;
import com.FindMyRoom.repository.StoryRepository;
import com.FindMyRoom.service.StoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class StoryServiceImpl implements StoryService {
    private final StoryRepository repo;
    private final StoryMapping mapping;
    private final Logger logger = Logger.getLogger(StoryServiceImpl.class.getName());

    public StoryServiceImpl(StoryRepository repo) {
        this.repo = repo;
        this.mapping = new StoryMapping();
    }

    @Override
    public List<StoryDTO> getAllStoryDTOs() throws Exception {
        logger.info("getAllStoryDTOs");
        List<StoryDTO> storyList = new ArrayList<>();
        List<Story> list = repo.findAll();
        if (list.isEmpty()) {
            throw new Exception("No Story");
        }
        list.forEach(n -> storyList.add(mapping.convert(n)));
        return storyList;
    }

    @Override
    public StoryDTO getStoryDTOById(Long id) throws Exception {
        logger.info("getStoryDTOById");
        StoryDTO s = mapping.convert(repo.getById(id));
        if (s == null) {
            throw new Exception("No story with id = " + id);
        }
        return s;
    }
}
