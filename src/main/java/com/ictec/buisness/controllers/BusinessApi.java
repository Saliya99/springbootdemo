package com.ictec.buisness.controllers;

import com.ictec.buisness.URLConfig;
import com.ictec.buisness.httpentities.Address;
import com.ictec.buisness.httpentities.Business;
import com.ictec.buisness.httpentities.Location;
import com.ictec.buisness.repo.BusinessRepo;
import com.ictec.buisness.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class BusinessApi {

    @Autowired
    private BusinessRepo repo;

    @Autowired
    private BusinessService businessService;

    @Autowired
    private URLConfig urlConfig;

    @GetMapping("/show_business")
    public ResponseEntity<Business> showBusiness() {
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

    @PostMapping("/business")
    public ResponseEntity<Business> saveBusiness(@RequestBody Business b) {
        b = this.businessService.handleRegistration(b);
        return ResponseEntity.ok().body(b);
    }

    @GetMapping("/business")
    public ResponseEntity<List<Business>> getAllBusiness() {
        List<Business> all = repo.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/business/{id}")
    public ResponseEntity<Optional<Business>> findBusiness(@PathVariable Long id) {
        Optional<Business> b = this.repo.findById(id);
        return ResponseEntity.ok().body(b);
    }

    @DeleteMapping("/business/{id}")
    public ResponseEntity<Optional<Business>> deleteBusiness(@PathVariable Long id) {
        if (repo.existsById(id)) {
            this.repo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(400).build();
    }

    @GetMapping("/business/name/{end}")
    public ResponseEntity<List<Business>> findNameBusiness(@PathVariable String end) {
        List<Business> businessesWithEnd = repo.findByNameEndsWith(end);
        return ResponseEntity.ok().body(businessesWithEnd);
    }

    @GetMapping("/my_url")
    public ResponseEntity<String> findNameBusiness() {
        return ResponseEntity.ok().body(this.urlConfig.getUrl());
    }
}
