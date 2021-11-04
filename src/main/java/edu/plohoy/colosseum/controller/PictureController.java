package edu.plohoy.colosseum.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("covid-cert/verify")
public class PictureController {

    @GetMapping("/9910000037938419")
    public String myPicture(@Param(value = "lang") String lang, @Param(value = "ck")String ck) {
        return "plohoy_alexandr";
    }

    @GetMapping("/9910000037938429")
    public String catherinePicture(@Param(value = "lang") String lang, @Param(value = "ck")String ck) {
        return "catherine";
    }
}
