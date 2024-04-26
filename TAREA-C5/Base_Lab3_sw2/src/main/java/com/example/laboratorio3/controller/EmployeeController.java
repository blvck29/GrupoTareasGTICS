package com.example.laboratorio3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//COMPLETAR
@Controller
public class EmployeeController {

    //COMPLETAR
    @GetMapping(value = "/employee/main")
    public String mainPage(){
        return "employee/main";
    }
    @GetMapping(value = "/employee/lista")
    public String listaEmployee(   ){
        //COMPLETAR
        return "employee/lista";
    }
    @GetMapping(value = "/employee/neFrm")
    public String nuevoEmployeeForm( ) {
        //COMPLETAR
        return "/employee/neFrm";
    }

    @GetMapping(value = "/employee")
    public String guardarEmployee() {
        return "";
    }

    @GetMapping(value = "/employee/editFrm")
    public String editarEmployee() {
        return "employee/editFrm";
    }

    @GetMapping(value = "/employee")
    public String borrarEmpleado() {
        return "/employee/";
    }


}
