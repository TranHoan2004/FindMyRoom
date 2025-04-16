package com.FindMyRoom.controller;

import com.FindMyRoom.dto.PostDTO;
import com.FindMyRoom.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/list")
    public ResponseEntity<PagedModel<EntityModel<PostDTO>>> renderPosts(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "filter", required = false) String filterTitle,
            PagedResourcesAssembler<PostDTO> assembler) {
        try {
            logger.info(String.valueOf(page));
            Page<PostDTO> postDTOs = ps.getAllPostDTOsByPage(page - 1, 2);
            if (filterTitle != null) {
                Page<PostDTO> list = ps.getAllFilteredPostDTOsByPage(page - 1, 2, filterTitle);
                if (list.hasContent()) {
                    return ResponseEntity.ok(assembler.toModel(list));
                }
            }
            return ResponseEntity.ok(assembler.toModel(postDTOs));
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }
}
