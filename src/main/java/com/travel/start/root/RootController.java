package com.travel.start.root;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Ilmars MEDNIS
 * Created: 28.08.2021
 */

@Controller
@RequestMapping("/")
public class RootController {

    @GetMapping({"/","/index"})
    public String index() {
        return "old_index";
    }
}
