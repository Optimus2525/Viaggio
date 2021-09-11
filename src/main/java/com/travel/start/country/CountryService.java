package com.travel.start.country;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * User: Ilmars MEDNIS
 * Created: 29.08.2021
 */

@Service
@RequiredArgsConstructor
@Transactional

public class CountryService {

    private final CountryRepository countryRepository;


    public Page<Country> findAll(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber -1, 10);
        return countryRepository.findAll(pageable);
    }


    public Optional<Country> findById(Long countryId) {
        return Optional.empty();
    }


    public List<Country> findByCountryName(String countryName) {
        return countryRepository.findByCountryName(countryName);
    }

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }


    public Country update(Country country, Long countryId) {
        var existingCountry = findById(countryId)
                .orElseThrow(() -> new RuntimeException("Unable to find country with id " + countryId));
        existingCountry.setCountryName(country.getCountryName());
        return countryRepository.save(existingCountry);
    }


    public List<Country> getByName(String countryName) {
        return countryRepository.findByCountryName(countryName);
    }


    public void delete(Long countryId) {
        countryRepository.deleteById(countryId);
    }
}
