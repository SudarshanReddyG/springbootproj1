package com.sudarshan.springbootproj1.web;

import com.sudarshan.springbootproj1.bussiness.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/allguests")
public class GuestWebController {

    private final GuestService guestService;

    @Autowired
    public GuestWebController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public String getGuestList(Model model) {
        model.addAttribute("guestlist", guestService.getSortedGuestList());
        return "guestinfo";
    }
}