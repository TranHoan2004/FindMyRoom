package com.FindMyRoom.controller;

import com.FindMyRoom.dto.PostDTO;
import com.FindMyRoom.service.PostService;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService ps;
    private final Logger logger = Logger.getLogger(PostController.class.getName());

    public PostController(PostService ps) {
        this.ps = ps;
    }

    @GetMapping("/list/{page}")
    public ResponseEntity<PagedModel<EntityModel<PostDTO>>> renderPosts(@PathVariable int page,
                                                                        PagedResourcesAssembler<PostDTO> assembler) {
        try {
            logger.info(String.valueOf(page));
            return ResponseEntity.ok(assembler.toModel(ps.getAllPostDTOsByPage(page - 1, 2)));
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }
}
