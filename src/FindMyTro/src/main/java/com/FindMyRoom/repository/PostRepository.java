package com.FindMyRoom.repository;

import com.FindMyRoom.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
