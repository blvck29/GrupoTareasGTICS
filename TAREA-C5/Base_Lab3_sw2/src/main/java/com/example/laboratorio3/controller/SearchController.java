package com.example.laboratorio3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/Search", method= RequestMethod.GET)
public class SearchController {



    @GetMapping(value = {"/indice"})
    public String indice(){
        return "Search/indice";
    }





}
