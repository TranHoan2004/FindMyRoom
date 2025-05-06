package com.FindMyRoom.controller;

import com.FindMyRoom.dto.response.ApiResponse;
import com.FindMyRoom.dto.response.StoryResponse;
import com.FindMyRoom.service.StoryService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/story")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StoryController {
    StoryService storySrv;
    Logger logger = Logger.getLogger(StoryController.class.getName());

    public StoryController(StoryService storySrv) {
        this.storySrv = storySrv;
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<StoryResponse>>> renderAllStories() {
        try {
            return ResponseEntity.ok(new ApiResponse<>(
                    HttpStatus.OK.value(),
                    null,
                    storySrv.getAllStoryDTOs()
            ));
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }
}
