package com.travel.start.trip;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * User: Ilmars MEDNIS
 * Created: 28.08.2021
 */

public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findTripByTripCountry(String tripCountry);

    Page<Trip> findAllByOrderByTripCountryAsc(Pageable pageable);

    List<Trip> findTripByTripName(String tripName);

    Page<Trip> findAllByOrderByTripIdDesc(Pageable pageable);

    Page<Trip> findAllByOrderByTripStartDateDesc(Pageable pageable);

    Page<Trip> findAllByOrderByTripEndDateDesc(Pageable pageable);

    Page<Trip> findAllByOrderByTripNameAsc(Pageable pageable);

    Page<Trip> findAllByOrderByTripNumberOfPAXDesc(Pageable pageable);

    Page<Trip> findAll(Pageable pageable);

    @Query("SELECT e from Trip e where CURRENT_DATE BETWEEN e.tripStartDate AND e.tripEndDate")
    Page<Trip> findAllCurrentTrips(Pageable pageable);

    @Query("SELECT e from Trip e where e.tripStartDate > CURRENT_DATE")
    Page<Trip> findAllFutureTrips(Pageable pageable);

}
