package com.travel.start.pax;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User: Ilmars MEDNIS
 * Created: 03.09.2021
 */

@Repository
public interface PaxRepository extends JpaRepository<Pax, Long> {

    boolean existsByPaxName(String paxName);
}
