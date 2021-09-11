package com.travel.start.trippartner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: Ilmars MEDNIS
 * Created: 07.09.2021
 */

@Service
@RequiredArgsConstructor
@Transactional

public class TripPartnerService {

    private final TripPartnerRepository tripPartnerRepository;


}
