package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.PostDTO;
import com.FindMyRoom.mapping.PostMapping;
import com.FindMyRoom.model.Post;
import com.FindMyRoom.repository.PostRepository;
import com.FindMyRoom.service.PostService;
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
    public Page<PostDTO> getAllPostDTOsByPage(int page, int size) throws Exception {
        logger.info("getAllPostDTOs");
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> posts = repo.findAll(pageable);
        long count = repo.count();
        if (posts.isEmpty()) {
            throw new Exception("No posts");
        }

        List<Post> postDTOs = posts.getContent();
        List<PostDTO> postDTOList = new ArrayList<>();
        postDTOs.forEach(p -> postDTOList.add(mapping.convert(p)));

        return new PageImpl<>(postDTOList, pageable, count);
    }
}
