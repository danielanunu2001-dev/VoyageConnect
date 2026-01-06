package com.voyageconnect.service;

import com.voyageconnect.dao.DestinationDAO;
import com.voyageconnect.model.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DestinationServiceImpl implements DestinationService {

    private final DestinationDAO destinationDAO;

    @Autowired
    public DestinationServiceImpl(DestinationDAO destinationDAO) {
        this.destinationDAO = destinationDAO;
    }

    @Override
    @Transactional
    public Destination createDestination(Destination destination) {
        destinationDAO.save(destination);
        return destination;
    }

    @Override
    @Transactional
    public Destination updateDestination(Destination destination) {
        destinationDAO.update(destination);
        return destination;
    }

    @Override
    @Transactional
    public void deleteDestination(Long id) {
        destinationDAO.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Destination> getDestinationById(Long id) {
        return destinationDAO.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Destination> getAllDestinations() {
        return destinationDAO.findAll();
    }
}
