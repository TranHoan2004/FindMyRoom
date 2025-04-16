package com.FindMyRoom.controller;

import com.FindMyRoom.dto.StoryDTO;
import com.FindMyRoom.service.StoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/story")
public class StoryController {
    private final StoryService storySrv;
    private final Logger logger = Logger.getLogger(StoryController.class.getName());

    public StoryController(StoryService storySrv) {
        this.storySrv = storySrv;
    }

    @GetMapping("/list")
    public ResponseEntity<List<StoryDTO>> renderAllStories() {
        try {
            return ResponseEntity.ok(storySrv.getAllStoryDTOs());
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }
}
