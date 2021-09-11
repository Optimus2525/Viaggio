package com.travel.start.pax;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * User: Ilmars MEDNIS
 * Created: 03.09.2021
 */

@Service
@RequiredArgsConstructor
@Transactional
public class PaxService {

    private final PaxRepository paxRepository;


    public List<Pax> findAll() {
        return paxRepository.findAll();
    }


    public Optional<Pax> findById(Long paxId) {
        return paxRepository.findById(paxId);
    }


    public Pax savePax(Pax pax) {
        return paxRepository.save(pax);
    }


    public void deleteById(Long paxId) {
        paxRepository.deleteById(paxId);
    }
}
