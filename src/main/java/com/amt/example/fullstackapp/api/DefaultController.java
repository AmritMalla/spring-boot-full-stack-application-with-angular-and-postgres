package com.amt.example.fullstackapp.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Amrit Malla
 * date : 13/10/2020
 * time : 10:50 PM
 */
@Controller
public class DefaultController {
    @GetMapping("/")
    @ResponseBody
    public String homePage(){
        return "Home page";
    }
}
