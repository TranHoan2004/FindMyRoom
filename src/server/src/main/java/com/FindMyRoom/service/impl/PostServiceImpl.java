package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.response.PostResponseDTO;
import com.FindMyRoom.mapping.PostMapping;
import com.FindMyRoom.model.Post;
import com.FindMyRoom.repository.PostRepository;
import com.FindMyRoom.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostServiceImpl implements PostService {
    PostRepository repo;
    PostMapping mapping;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public PostServiceImpl(PostRepository repo) {
        this.repo = repo;
        this.mapping = new PostMapping();
    }

    @Override
    public Page<PostResponseDTO> getAllPostDTOsByPage(int page, int size) {
        logger.info("getAllPostDTOs");
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> posts = repo.findAll(pageable);
        long count = repo.count();
        return getPostDTOs(pageable, posts, count);
    }

    @Override
    public Page<PostResponseDTO> getAllFilteredPostDTOsByPage(int page, int size, @NotNull String string) {
        logger.info("getAllFilteredPostDTOsByPage");
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> posts = repo.findAllWithFilter(pageable, "%" + string.toLowerCase() + "%");
        return getPostDTOs(pageable, posts, posts.getTotalPages());
    }

    @Override
    public Page<PostResponseDTO> getAllPostByUserId(long id, int page, int size) {
        logger.info("getAllPostByUserId");
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> posts = repo.findAllByUserId(id, pageable);
        return getPostDTOs(pageable, posts, posts.getTotalElements());
    }

    @NotNull
    private Page<PostResponseDTO> getPostDTOs(Pageable pageable, @NotNull Page<Post> posts, long count) {
        if (posts.isEmpty()) {
            throw new EntityNotFoundException("No posts");
        }

        List<Post> postDTOs = posts.getContent();
        List<PostResponseDTO> postDTOList = new ArrayList<>();
        postDTOs.forEach(p -> postDTOList.add(mapping.convert(p)));
        return new PageImpl<>(postDTOList, pageable, count);
    }
}
