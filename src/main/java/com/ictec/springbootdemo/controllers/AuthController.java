package com.ictec.springbootdemo.controllers;

import com.ictec.springbootdemo.httpentities.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {
    @RequestMapping(method = RequestMethod.POST, path = "/lang/{language}/login")
    public ResponseEntity<String> doLogin(@PathVariable String language,
                                          @RequestBody LoginRequest l){
//        return ResponseEntity.ok(loginData.getEmail() + " | " + loginData.getPassword());

        if(l.getEmail().equals("joe@mtron.me") && l.getPassword().equals("1234")){
            return ResponseEntity.ok("{}");
        }
        return ResponseEntity.status(401).body("{}");
    }
}
