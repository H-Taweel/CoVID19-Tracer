package com.redi.j2.CoVID19Tracer.controllers;

//import com.redi.j2.CoVID19Tracer.models.LocationStats;

import com.redi.j2.CoVID19Tracer.models.MapStats;
import com.redi.j2.CoVID19Tracer.services.Covid19DataService;
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
        List<MapStats> mapStats = covid19DataService.getMapStats();
        long totalReportedCases = mapStats.stream().mapToLong(stat -> stat.getCases()).sum();
        long totalReportedDeaths = mapStats.stream().mapToLong(stat -> stat.getDeaths()).sum();
        long totalNewCases = mapStats.stream().mapToLong(stat -> stat.getTodayCases()).sum();
        long totalNewDeaths = mapStats.stream().mapToLong(stat -> stat.getTodayDeaths()).sum();
        model.addAttribute("mapStats",mapStats);
        model.addAttribute("totalReportedCases",totalReportedCases);
        model.addAttribute("totalReportedDeaths",totalReportedDeaths);
        model.addAttribute("totalNewCases",totalNewCases);
        model.addAttribute("totalNewDeaths",totalNewDeaths);

        return "home";
    }
}
