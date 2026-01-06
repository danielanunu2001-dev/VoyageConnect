package com.voyageconnect.service;

import com.voyageconnect.model.Destination;
import java.util.List;
import java.util.Optional;

public interface DestinationService {
    Destination createDestination(Destination destination);
    Destination updateDestination(Destination destination);
    void deleteDestination(Long id);
    Optional<Destination> getDestinationById(Long id);
    List<Destination> getAllDestinations();
}
