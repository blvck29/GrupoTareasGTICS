package com.example.laboratorio3.controller;

import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//COMPLETAR
@Controller
public class EmployeeController {

    final EmployeesRepository employeesRepository;

    public EmployeeController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    //COMPLETAR
    @GetMapping(value = "/employee/lista")
    public String listaEmployee(Model model){
        List<Employees> listaEmpleados = employeesRepository.findAll();
        model.addAttribute("listaEmpleados", listaEmpleados);
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
