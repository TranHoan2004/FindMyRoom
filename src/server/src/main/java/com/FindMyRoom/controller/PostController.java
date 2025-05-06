package com.FindMyRoom.controller;

import com.FindMyRoom.dto.response.ApiResponse;
import com.FindMyRoom.dto.response.PostResponseDTO;
import com.FindMyRoom.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/posts")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostController {
    PostService ps;
    Logger logger = Logger.getLogger(PostController.class.getName());

    public PostController(PostService ps) {
        this.ps = ps;
    }

    @GetMapping("/list")
    public ResponseEntity<?> renderPosts(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "filter", required = false) String filterTitle,
            PagedResourcesAssembler<PostResponseDTO> assembler,
            HttpServletRequest request) {
        try {
            logger.info("renderPosts");
            if (isForbiddenContent(request, "ExportPost.js")) {
                throw new AccessDeniedException("Access denied");
            }

            Page<PostResponseDTO> postDTOs = ps.getAllPostDTOsByPage(page - 1, 2);
            if (filterTitle != null) {
                Page<PostResponseDTO> list = ps.getAllFilteredPostDTOsByPage(page - 1, 2, filterTitle);
                if (list.hasContent()) {
                    return renderData(assembler, list);
                }
            }
            return renderData(assembler, postDTOs);
        } catch (AccessDeniedException e) {
            throw e;
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<?> renderPostByUserID(
            @PathVariable long id,
            @RequestParam(value = "page", defaultValue = "1") int page,
            PagedResourcesAssembler<PostResponseDTO> assembler,
            HttpServletRequest request) {
        try {
            logger.info("renderPostByUserID");
            if (isForbiddenContent(request, "ExportPost.js")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied");
            }

            Page<PostResponseDTO> postDTOs = ps.getAllPostByUserId(id, page - 1, 2);
            return renderData(assembler, postDTOs);
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }

    @NotNull
    private ResponseEntity<?> renderData(@NotNull PagedResourcesAssembler<PostResponseDTO> assembler, Page<PostResponseDTO> postDTOs) {
        return ResponseEntity.ok(new ApiResponse<>(
                HttpStatus.OK.value(),
                null,
                assembler.toModel(postDTOs)
        ));
    }

    private boolean isForbiddenContent(@NotNull HttpServletRequest request, String key) {
        String requestedBy = request.getHeader("X-Requested-By");
        return requestedBy == null || !requestedBy.equals(key);
    }
}
