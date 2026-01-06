package com.voyageconnect.dao;

import com.voyageconnect.model.Destination;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class DestinationDAOImpl implements DestinationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Destination destination) {
        entityManager.persist(destination);
    }

    @Override
    public void update(Destination destination) {
        entityManager.merge(destination);
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(destination -> entityManager.remove(destination));
    }

    @Override
    public Optional<Destination> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Destination.class, id));
    }

    @Override
    public List<Destination> findAll() {
        TypedQuery<Destination> query = entityManager.createQuery("FROM Destination", Destination.class);
        return query.getResultList();
    }
}
