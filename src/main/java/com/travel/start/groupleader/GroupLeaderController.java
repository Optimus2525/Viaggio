package com.travel.start.groupleader;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Ilmars MEDNIS
 * Created: 07.09.2021
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/groupleaders")

public class GroupLeaderController {

    private final GroupleaderService groupleaderService;


}
