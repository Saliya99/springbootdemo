package com.ictec.buisness.services;

import com.ictec.buisness.httpentities.Business;
import com.ictec.buisness.repo.BusinessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessService {
    @Autowired
    private BusinessRepo repo;

    public Business handleRegistration(Business b){
        //Save
        //Email
        //Profile Image Upload
        //Profile Table Update

        return this.repo.save(b);
    }
}
