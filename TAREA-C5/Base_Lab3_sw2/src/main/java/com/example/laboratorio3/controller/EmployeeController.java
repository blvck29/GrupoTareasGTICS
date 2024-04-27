package com.example.laboratorio3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//COMPLETAR
@Controller
public class EmployeeController {

    //COMPLETAR
    @GetMapping(value = "/employee/lista")
    public String listaEmployee(   ){
        //COMPLETAR
        return "employee/lista";
    }
    @GetMapping(value = "/employee/newFrm")
    public String nuevoEmployeeForm( ) {
        //COMPLETAR
        return "employee/newFrm";
    }

    @GetMapping(value = "/employee")
    public String guardarEmployee() {
        return "employee/lista";
    }

    @GetMapping(value = "/employee/editFrm")
    public String editarEmployee() {
        return "employee/editFrm";
    }

    @GetMapping(value = "/employee/borrar")
    public String borrarEmpleado(Model model) {
        return "redirect:employee/lista";
    }


}
