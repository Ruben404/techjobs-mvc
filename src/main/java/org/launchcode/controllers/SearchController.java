package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value = "results")
    public String Results(Model model, @RequestParam String searchTerm, @RequestParam String searchType) {
        if (searchType.equals("all")) {
            ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);
            model.addAttribute("title", "Search Results for: " + searchTerm);
            model.addAttribute("jobs", jobs);
        } else {
            ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("title", "Search Results for: " + searchTerm);
            model.addAttribute("jobs", jobs);
        }

        return "search";
    }

//    @RequestMapping(value = "results", method = RequestMethod.POST)
//    public String processShowResults(@RequestParam String searchTerm) {
//    }

}



//    public String search() {
//
//        Model name = new model
//        name.addAttribute("columns", ListController.columnChoices);
//    }
