package com.travel.start.tollroad;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Ilmars MEDNIS
 * Created: 07.09.2021
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/tollroads")

public class TollRoadController {

    private final TollRoadService tollRoadService;
}
