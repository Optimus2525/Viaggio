package com.travel.start.trippartner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Ilmars MEDNIS
 * Created: 07.09.2021
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/trippartners")

public class TripPartnerController {

    private final TripPartnerService tripPartnerService;


}
