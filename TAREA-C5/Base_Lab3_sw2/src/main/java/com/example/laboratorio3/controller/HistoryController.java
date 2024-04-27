package com.example.laboratorio3.controller;

import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.ui.Model;
import com.example.laboratorio3.repository.JobHistoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HistoryController {
//COMPLETAR
    final JobHistoryRepository jobHistoryRepository;
    final EmployeesRepository employeesRepository;
    public HistoryController(JobHistoryRepository jobHistoryRepository,EmployeesRepository employeesRepository) {
        this.jobHistoryRepository = jobHistoryRepository;
        this.employeesRepository = employeesRepository;
    }
    @GetMapping(value = "/history/lista")
    public String listaHistory(Model model){
        model.addAttribute("listaHistorialEmpleados",employeesRepository.listaHistoriaEmpleado(""));
        return "history/history";
    }
    @PostMapping(value = "/history/buscar")
    public String buscarHistory(Model model, @RequestParam(value = "word",required = false,defaultValue = "") String busqueda) {
        model.addAttribute("listaHistorialEmpleados",employeesRepository.listaHistoriaEmpleado(busqueda));
        return "history/history";
    }


}
