package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Users;
import com.FindMyRoom.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserRepositoryImpl implements UserRepository {
    private final EntityManager em;

    public UserRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @NotNull
    @Override
    public <S extends Users> S save(@NotNull S entity) {
        return em.unwrap(Session.class).merge(entity);
    }

    @NotNull
    @Override
    public <S extends Users> Iterable<S> saveAll(@NotNull Iterable<S> entities) {
        return null;
    }

    @NotNull
    @Override
    public Optional<Users> findById(@NotNull Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(@NotNull Integer integer) {
        return false;
    }

    @NotNull
    @Override
    public Iterable<Users> findAll() {
        return em.unwrap(Session.class)
                .createQuery("from Users", Users.class)
                .list();
    }

    @NotNull
    @Override
    public Iterable<Users> findAllById(@NotNull Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(@NotNull Integer integer) {

    }

    @Override
    public void delete(@NotNull Users entity) {

    }

    @Override
    public void deleteAllById(@NotNull Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(@NotNull Iterable<? extends Users> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<String> getEmails() {
        Session session = em.unwrap(Session.class);
        List<String> emails = session.createQuery("select u.email from Users u", String.class).getResultList();
        session.close();
        return emails;
    }

    @Override
    public Users getByEmail(String email) {
        Session session = em.unwrap(Session.class);
        Users user = session.createQuery("select u from Users u where u.email=:email", Users.class)
                .setParameter("email", email)
                .getSingleResult();
        session.close();
        return user;
    }
}
