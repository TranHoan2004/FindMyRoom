package com.FindMyRoom.controller;

import com.FindMyRoom.dto.PostDTO;
import com.FindMyRoom.service.PostService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
            PagedResourcesAssembler<PostDTO> assembler,
            @RequestParam(value = "filter", required = false) String filterTitle) {
        try {
            logger.info(String.valueOf(page));
            logger.info(filterTitle);
            if (filterTitle != null) {
                Page<PostDTO> list = ps.getAllPostDTOsByPage(page - 1, 2);

                // Lọc theo đầu vào
                List<PostDTO> newList = list.getContent().stream()
                        .filter(post -> post.getContent().toLowerCase().contains(filterTitle.toLowerCase()) ||
                                post.getTitle().toLowerCase().contains(filterTitle.toLowerCase()))
                        .collect(Collectors.toList());

                // Tạo ds phân trang mới
                Page<PostDTO> newPage = new PageImpl<>(newList, list.getPageable(), newList.size());

                return ResponseEntity.ok(assembler.toModel(newPage));
            }
            return ResponseEntity.ok(assembler.toModel(ps.getAllPostDTOsByPage(page - 1, 2)));
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        logger.info("Go here");
        return ResponseEntity.noContent().build();
    }
}
