package com.travel.start.trip;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: Ilmars MEDNIS
 * Created: 29.08.2021
 */

@Service
@RequiredArgsConstructor
@Transactional

public class TripService {

    private final TripRepository tripRepository;

    // Find all trips paginated
    public Page<Trip> findAll(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber -1, 8);
        return tripRepository.findAll(pageable);
    }

    public List<Trip> getByName(String tripName) {
        return tripRepository.findTripByTripName(tripName);
    }

    public void delete(Long id) {
        tripRepository.deleteById(id);
    }

    public List<Trip> findTripByCountry(String tripCountry) {
        return tripRepository.findTripByTripCountry(tripCountry);
    }

    public Trip findById(Long tripId) {
        return tripRepository.getById(tripId);
    }

    public Trip saveTrip(Trip trip) {
        return tripRepository.save(trip);
    }

}
