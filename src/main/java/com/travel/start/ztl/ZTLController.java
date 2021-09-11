package com.travel.start.ztl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Ilmars MEDNIS
 * Created: 07.09.2021
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/ztl")

public class ZTLController {

    private final ZTLService ztlService;

}
