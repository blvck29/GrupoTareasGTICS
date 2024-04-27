package com.example.laboratorio3.controller;

import org.springframework.web.bind.annotation.GetMapping;

//COMPLETAR
public class SearchController {

    //COMPLETAR

    @GetMapping(value = {"","/"})
    public String indice(){
        return "Search/indice";
    }


//COMPLETAR


}
