package com.example.laboratorio3.controller;

import com.example.laboratorio3.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/departments")
    public String getDepartmentStats(Model model) {
        model.addAttribute("lista", countryRepository.findDepartmentsWithMoreThanThreeEmployees());
        return "/departments";
    }
}
