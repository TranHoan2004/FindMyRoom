package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Post;
import com.FindMyRoom.repository.PostRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class PostRepositoryImpl implements PostRepository {

    @Override
    @NotNull
    public <S extends Post> S save(@NotNull S entity) {
        return null;
    }

    @Override
    @NotNull
    public <S extends Post> Iterable<S> saveAll(@NotNull Iterable<S> entities) {
        return null;
    }

    @Override
    @NotNull
    public Optional<Post> findById(@NotNull Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(@NotNull Long aLong) {
        return false;
    }

    @Override
    @NotNull
    public Iterable<Post> findAll() {
        return null;
    }

    @Override
    @NotNull
    public Iterable<Post> findAllById(@NotNull Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(@NotNull Long aLong) {

    }

    @Override
    public void delete(@NotNull Post entity) {

    }

    @Override
    public void deleteAllById(@NotNull Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(@NotNull Iterable<? extends Post> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
