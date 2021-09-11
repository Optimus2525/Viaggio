package com.travel.start.country;

import com.travel.start.trip.Trip;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * User: Ilmars MEDNIS
 * Created: 29.08.2021
 */

@Controller
@RequestMapping("/countries")
@RequiredArgsConstructor

public class CountryController {

    private final CountryService countryService;

    // Show all countries existing in DB
    @GetMapping("/show_all_countries")
    public String getAllCountries(Model model) {
        return getAllCountriesByPage(model, 1);
    }

    //
    @GetMapping("/show_all_countries/page/{pageNumber}")
    public String getAllCountriesByPage(Model model, @PathVariable("pageNumber") int currentPage) {
        Page<Country> page = countryService.findAll(currentPage);
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("all_countries", page.getContent());
        model.addAttribute("paginationLink", "/countries/show_all_countries/page/");
        return "/country/all_countries";
    }

    //Receives from the form data as model attribute "country" and saves in DB
    @PostMapping("/save_country")
    public String saveNewCountry(@ModelAttribute("country") Country country) {
        countryService.saveCountry(country);
        return "/country/all_countries";
    }

    // Shoe New Country form to enter new country data
    @GetMapping("/show_new_country_form")
    public String showNewCountryForm(Model model) {
        model.addAttribute("pageTitle", "Viaggio");
        Country country = new Country();
        model.addAttribute("country", country);
        return "/country/add_country";
    }

}
