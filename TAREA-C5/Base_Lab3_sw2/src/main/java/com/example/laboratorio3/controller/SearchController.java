package com.example.laboratorio3.controller;

import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.repository.CountryRepository;
import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value="/Search", method= RequestMethod.GET)
public class SearchController {

    final EmployeesRepository employeesRepository;

    public SearchController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @GetMapping(value = {"/indice"})
    public String indice(){
        return "Search/indice";
    }

    @GetMapping("/SalarioMayor")
    public String getSalarioMayor(Model model) {
        List<Employees> listaResult =  employeesRepository.findEmployeesWithHighSalary();
        model.addAttribute("listaResult",listaResult);
        return "Search/SalarioMayor";
    }

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("Search/departments")
    public String getDepartmentStats(Model model) {
        model.addAttribute("lista", countryRepository.findDepartmentsWithMoreThanThreeEmployees());
        return "Search/departments";
    }

}
