package edu.plohoy.colosseum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("covid-cert/verify")
public class PictureController {

    @GetMapping("/9910000037938419")
    public String myPicture() {
        return "plohoy_alexandr";
    }

    @GetMapping("/9910000037938429")
    public String catherinePicture() {
        return "catherine";
    }
}
