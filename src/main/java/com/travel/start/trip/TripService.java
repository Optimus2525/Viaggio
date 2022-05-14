package com.travel.start.trip;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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

    // Find all trips paginated by Id Descending
    public Page<Trip> getAllTripsByTripId(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber -1, 8);
        return tripRepository.findAllByOrderByTripIdDesc(pageable);
    }

    // Find all trips paginated by Start Date Descending
    public Page<Trip> getAllTripsByTripStartDate(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber -1, 8);
        return tripRepository.findAllByOrderByTripStartDateDesc(pageable);
    }

    // Find all trips paginated by Start Date Descending
    public Page<Trip> getAllTripsByTripCountry(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber -1, 8);
        return tripRepository.findAllByOrderByTripCountryAsc(pageable);
    }

    // Find all trips paginated by Trip Name Descending
    public Page<Trip> getAllTripsByTripName(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 8);
        return tripRepository.findAllByOrderByTripNameAsc(pageable);
    }

    // Find all trips paginated happening Right Now
    public Page<Trip> getCurrentActualTrips(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 8);
        return tripRepository.findAllCurrentTrips(pageable);
    }

    public List<Trip> getTripByTripName(String tripName) {
        return tripRepository.findTripByTripName(tripName);
    }

    public void delete(Long id) {
        tripRepository.deleteById(id);
    }

    public List<Trip> getAllTripsByCountryDesc(String tripCountry) {
        return tripRepository.findTripByTripCountry(tripCountry);
    }

    public Trip findById(Long tripId) {
        return tripRepository.getById(tripId);
    }

    public Trip saveTrip(Trip trip) {
        return tripRepository.save(trip);
    }

}
