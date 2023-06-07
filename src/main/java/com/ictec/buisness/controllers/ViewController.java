package com.ictec.buisness.controllers;

import com.ictec.buisness.httpentities.Business;
import com.ictec.buisness.repo.BusinessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewController {
    @Autowired
    private BusinessRepo repo;

    @GetMapping("/business")
    public String showBusinessPage(Model model){
        List<Business> all = repo.findAll();
        model.addAttribute("all", all);
        return "allbusinesses";
    }
}
