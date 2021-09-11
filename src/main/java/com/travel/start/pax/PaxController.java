package com.travel.start.pax;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * User: Ilmars MEDNIS
 * Created: 04.09.2021
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/pax")
public class PaxController {

    private final PaxService paxService;

    @GetMapping("/all_pax")
    public String getAllPax(Model model) {
        model.addAttribute("all_pax", paxService.findAll());
        return "/pax/all_pax";
    }



}
