package com.example.laboratorio3.controller;

import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping(value = "/employee/newEmployee")
    public String newEmployee(@RequestParam("nombre") String nombre,
                              @RequestParam("apellido") String apellido,
                              @RequestParam("correo") String correo,
                              @RequestParam("contrasena") String contrasena,
                              @RequestParam("puesto") String puesto,
                              @RequestParam("sueldo") String sueldo,
                              @RequestParam("jefe") String jefe,
                              @RequestParam("departamento") String departamento) {

        return "redirect:/employee/lista";
    }

    @GetMapping(value = "/employee/borrar")
    public String borrarEmpleado(Model model) {
        return "redirect:employee/lista";
    }

    @PostMapping(value = "/employee/buscar")
    public String buscarEmpleado(Model model, @RequestParam("word") String word) {

        System.out.println(word);

        List <Employees> lista = employeesRepository.ListaFiltrada(word);

        model.addAttribute("listaEmpleados", lista);


        return "employee/lista";
    }

}
