package com.travel.start.trip;

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
@RequiredArgsConstructor
@RequestMapping("/trips")

public class TripsController {

    private final TripService tripService;

    // Show all trips existing in DB paginated
    @GetMapping("/all_trips")
    public String getAllTrips(Model model) {
        return getAllTripsByPage(model, 1);
    }

    //
    @GetMapping("/all_trips/page/{pageNumber}")
    public String getAllTripsByPage(Model model, @PathVariable("pageNumber") int currentPage) {
        Page<Trip> page = tripService.findAll(currentPage);
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("all_trips", page.getContent());
        model.addAttribute("paginationLink", "/trips/all_trips/page/");
        return "/trip/all_trips";
    }

    // Shoe New Trip form to enter new trip data
    @GetMapping("/show_new_trip_form")
    public String showNewTripForm(Model model) {
        Trip trip = new Trip();
        model.addAttribute("trip", trip);
        return "/trip/add_trip";
    }

    //Receives from the form data as model attribute "trip" and saves in DB
    @PostMapping("/save_trip")
    public String saveNewTrip(@ModelAttribute("trip") Trip trip) {
        tripService.saveTrip(trip);
        return "redirect:/trips/all_trips";
    }

    @GetMapping("/show_update_form/{id}")
    public String showTripUpdateForm(@PathVariable("id") Long tripId, Model model) {
        Trip trip = tripService.findById(tripId);
        model.addAttribute("trip", trip);
        return "/trip/update_trip";
    }

}
