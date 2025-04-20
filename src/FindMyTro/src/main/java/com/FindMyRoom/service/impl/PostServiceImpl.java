package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.response.PostResponseDTO;
import com.FindMyRoom.mapping.PostMapping;
import com.FindMyRoom.model.Post;
import com.FindMyRoom.repository.PostRepository;
import com.FindMyRoom.service.PostService;
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
public class PostServiceImpl implements PostService {
    private final PostRepository repo;
    private final PostMapping mapping;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public PostServiceImpl(PostRepository repo) {
        this.repo = repo;
        this.mapping = new PostMapping();
    }

    @Override
    public Page<PostResponseDTO> getAllPostDTOsByPage(int page, int size) throws Exception {
        logger.info("getAllPostDTOs");
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> posts = repo.findAll(pageable);
        long count = repo.count();
        return getPostDTOs(pageable, posts, count);
    }

    @Override
    public Page<PostResponseDTO> getAllFilteredPostDTOsByPage(int page, int size, @NotNull String string) throws Exception {
        logger.info("getAllFilteredPostDTOsByPage");
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> posts = repo.findAllWithFilter(pageable, "%" + string.toLowerCase() + "%");
        return getPostDTOs(pageable, posts, posts.getTotalPages());
    }

    @NotNull
    private Page<PostResponseDTO> getPostDTOs(Pageable pageable, @NotNull Page<Post> posts, long count) throws Exception {
        if (posts.isEmpty()) {
            throw new Exception("No posts");
        }

        List<Post> postDTOs = posts.getContent();
        List<PostResponseDTO> postDTOList = new ArrayList<>();
        postDTOs.forEach(p -> postDTOList.add(mapping.convert(p)));

        return new PageImpl<>(postDTOList, pageable, count);
    }
}
