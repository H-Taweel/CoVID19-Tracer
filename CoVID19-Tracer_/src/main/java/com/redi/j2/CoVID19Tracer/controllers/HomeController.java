package com.redi.j2.CoVID19Tracer.controllers;

import com.redi.j2.CoVID19Tracer.models.LocationStats;
import com.redi.j2.CoVID19Tracer.services.Covid19DataService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    Covid19DataService covid19DataService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = covid19DataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        model.addAttribute("locationStats",allStats);
        model.addAttribute("totalReportedCases",totalReportedCases);

        return "home";
    }
}
