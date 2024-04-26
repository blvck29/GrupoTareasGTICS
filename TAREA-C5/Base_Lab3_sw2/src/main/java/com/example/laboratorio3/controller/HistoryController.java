package com.example.laboratorio3.controller;


import com.example.laboratorio3.repository.JobHistoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistoryController {
//COMPLETAR
final JobHistoryRepository jobHistoryRepository;

    public HistoryController(JobHistoryRepository jobHistoryRepository) {
        this.jobHistoryRepository = jobHistoryRepository;
    }
    @GetMapping(value = "/history/lista")
    public String listaHistory(){
        return "history/lista";
    }

}
