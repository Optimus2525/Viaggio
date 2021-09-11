package com.travel.start.ztl;

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

public class ZTLService {

    private final ZTLRepository ztlRepository;
}
