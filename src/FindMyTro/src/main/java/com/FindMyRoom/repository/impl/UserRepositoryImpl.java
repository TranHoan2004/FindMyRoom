package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Users;
import com.FindMyRoom.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
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

    @Override
    public <S extends Users> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Users> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Users> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Users> findAll() {
        return null;
    }

    @Override
    public Iterable<Users> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Users entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Users> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
