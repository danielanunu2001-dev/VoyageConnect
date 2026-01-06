package com.voyageconnect.dao;

import com.voyageconnect.model.Destination;
import java.util.List;
import java.util.Optional;

public interface DestinationDAO {
    void save(Destination destination);
    void update(Destination destination);
    void deleteById(Long id);
    Optional<Destination> findById(Long id);
    List<Destination> findAll();
}
