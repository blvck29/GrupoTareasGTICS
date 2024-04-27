package com.example.laboratorio3.controller;

import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.repository.EmployeesRepository;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.example.laboratorio3.repository.JobRepository;
import com.example.laboratorio3.repository.LocationRepository;
>>>>>>> 4a288d680eda836e09c7c23fd2ed24413213b83f
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//COMPLETAR
@Controller
public class EmployeeController {

    final EmployeesRepository employeesRepository;
    final JobRepository jobRepository;
    final LocationRepository locationRepository;

    public EmployeeController(EmployeesRepository employeesRepository, JobRepository jobRepository, LocationRepository locationRepository) {
        this.employeesRepository = employeesRepository;
        this.jobRepository = jobRepository;
        this.locationRepository = locationRepository;
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
    public String buscarEmpleado(Model model, RedirectAttributes attr, @RequestParam("word") String word) {

        System.out.println("la palabra es: " + word);

        List<Employees> lista = employeesRepository.ListaFiltrada(word);

        if(lista == null){
            System.out.println("Lista nula");
        }

       model.addAttribute("listaEmpleados", lista);

        return "employee/lista";
    }



}
