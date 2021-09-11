package com.travel.start.country;

import com.travel.start.trip.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * User: Ilmars MEDNIS
 * Created: 29.08.2021
 */


public interface CountryRepository extends JpaRepository<Country,Long> {

       List<Country> findByCountryName(String countryName);

       Page<Country> findAll(Pageable pageable);
}
