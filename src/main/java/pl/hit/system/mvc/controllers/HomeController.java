package pl.hit.system.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "home")
public class HomeController {

    @GetMapping
    public String giveHomePage() {
        return "/home";
    }
}
