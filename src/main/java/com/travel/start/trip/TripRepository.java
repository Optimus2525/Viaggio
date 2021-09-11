package com.travel.start.trip;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * User: Ilmars MEDNIS
 * Created: 28.08.2021
 */

public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findTripByTripCountry(String tripCountry);

    List<Trip> findTripByTripName(String tripName);

    Page<Trip> findAll(Pageable pageable);
}
