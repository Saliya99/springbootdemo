package com.ictec.buisness.controllers;

import com.ictec.buisness.httpentities.Buisness;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {
    @RequestMapping(method = RequestMethod.POST, path = "/add_buisness")
    public ResponseEntity<String> addBuisness(@RequestBody Buisness b){
        String businessDetails = "Name: " + b.getName() +
                "\nPhone Number: " + b.getPhone_number() +
                "\nAddress: " + b.getAddress().getLine1() + ", " +
                b.getAddress().getLine2() + ", " + b.getAddress().getState() +
                "\nLocation: Latitude => " + b.getLocation().getLatitude() +
                ", Longitude => " + b.getLocation().getLongitude();
        return ResponseEntity.ok(businessDetails);
    }
}
