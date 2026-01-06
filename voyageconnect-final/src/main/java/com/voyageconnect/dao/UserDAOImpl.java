package com.voyageconnect.dao;

import com.voyageconnect.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery("FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        return query.getResultStream().findFirst();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }
}
