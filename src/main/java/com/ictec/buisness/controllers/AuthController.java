package com.ictec.buisness.controllers;

import com.ictec.buisness.httpentities.Address;
import com.ictec.buisness.httpentities.Business;
import com.ictec.buisness.httpentities.Location;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {
    @RequestMapping(method = RequestMethod.POST, path = "/add_business")
    public ResponseEntity<String> addBuisness(@RequestBody Business b){
        String businessDetails = "Name: " + b.getName() +
                "\nPhone Number: " + b.getPhone_number() +
                "\nAddress: " + b.getAddress().getLine1() + ", " +
                b.getAddress().getLine2() + ", " + b.getAddress().getState() +
                ", " + b.getAddress().getCity() + ", " + b.getAddress().getCountry() +
                "\nLocation: Latitude => " + b.getLocation().getLatitude() +
                ", Longitude => " + b.getLocation().getLongitude();
        return ResponseEntity.ok(businessDetails);
    }

    @GetMapping("/show_business")
    public ResponseEntity<Business> showBusiness(){
        Business b = new Business();
        b.setName("Mtron");
        b.setPhone_number("+1345627378");

        Address a = new Address();
        a.setLine1("254/1A");
        a.setLine2("Robert Gunawardhana Road");
        a.setState("Western");
        a.setCity("Battaramulla");
        a.setCountry("Sri Lanka");

        b.setAddress(a);

        Location l = new Location();
        l.setLatitude("41.26353");
        l.setLongitude("-80.23453");

        b.setLocation(l);

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(b);
    }
}
