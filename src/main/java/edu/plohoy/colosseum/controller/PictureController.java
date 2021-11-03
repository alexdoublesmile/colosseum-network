package edu.plohoy.colosseum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("qr")
public class PictureController {

    @GetMapping("/plohoy_alexandr")
    public String myPicture() {
        return "my_picture";
    }
}
