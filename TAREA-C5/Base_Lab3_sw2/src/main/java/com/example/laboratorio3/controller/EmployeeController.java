package com.example.laboratorio3.controller;

import com.example.laboratorio3.entity.Department;
import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.entity.Job;
import com.example.laboratorio3.repository.DepartmetRepository;
import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.laboratorio3.repository.JobRepository;
import com.example.laboratorio3.repository.LocationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//COMPLETAR
@Controller
public class EmployeeController {

    final EmployeesRepository employeesRepository;
    final JobRepository jobRepository;
    final LocationRepository locationRepository;
    final DepartmetRepository departmetRepository;

    public EmployeeController(EmployeesRepository employeesRepository, JobRepository jobRepository, LocationRepository locationRepository, DepartmetRepository departmetRepository) {
        this.employeesRepository = employeesRepository;
        this.jobRepository = jobRepository;
        this.locationRepository = locationRepository;
        this.departmetRepository = departmetRepository;
    }

    //COMPLETAR
    @GetMapping(value = "/employee/lista")
    public String listaEmployee(Model model){
        List<Employees> listaEmpleados = employeesRepository.findAll();
        model.addAttribute("listaEmpleados", listaEmpleados);
        return "employee/lista";
    }
    @GetMapping(value = "/employee/newFrm")
    public String nuevoEmployeeForm(Model model) {
        List<Job> listaPuestos = jobRepository.findAll();
        List<Department> listaJefes = departmetRepository.findAll();

        model.addAttribute("listaPuestos", listaPuestos);
        model.addAttribute("listaJefes",listaJefes);
        return "employee/newFrm";
    }

    @GetMapping(value = "/employee")
    public String guardarEmployee() {
        return "employee/lista";
    }

    @GetMapping(value = "/employee/editFrm")
    public String editarEmployee(Model model) {
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
                              @RequestParam("departamento") String departamento,
                              RedirectAttributes attr) {

        Optional<Job> optionalJob = jobRepository.findById(puesto);
        Job empJob = new Job();
        Optional<Employees> optionalManager = employeesRepository.findById(Integer.valueOf(jefe));
        Employees empManager = new Employees();
        Optional<Department> optionalDepartment = departmetRepository.findById(Integer.valueOf(departamento));
        Department empDepartment = new Department();

        if (optionalJob.isPresent()){
            empJob = optionalJob.get();
        }
        if (optionalManager.isPresent()){
            empManager = optionalManager.get();
        }
        if (optionalDepartment.isPresent()){
            empDepartment = optionalDepartment.get();
        }

        Employees employee = new Employees();
        employee.setEmployee_id(employeesRepository.findLastEmployeeId() + 1);
        employee.setFirstName(nombre);
        employee.setLastName(apellido);
        employee.setEmail(correo);
        employee.setPassword(contrasena);
        java.sql.Date sqlDate = Date.valueOf(LocalDate.now());
        employee.setHireDate(sqlDate);
        employee.setJob(empJob);
        employee.setSalary(Float.parseFloat(sueldo));
        employee.setManager(empManager);
        employee.setDepartment(empDepartment);

        employeesRepository.save(employee);

        attr.addAttribute("msg", "Uusuario creado exitosamente");
        return "redirect:/employee/lista";
    }

    @GetMapping(value = "/employee/borrar")
    public String borrarEmpleado(Model model, @RequestParam("id") String id) {

        Optional<Employees> optionalEmployee = employeesRepository.findById(Integer.valueOf(id));

        if (optionalEmployee.isPresent()) {
            employeesRepository.deleteById(Integer.valueOf(id));
        }

        return "redirect:lista";
    }

    @PostMapping(value = "/employee/buscar")
    public String buscarEmpleado(Model model, RedirectAttributes attr, @RequestParam("word") String word) {


        List<Employees> lista = employeesRepository.ListaFiltrada(word);

        if(lista == null){
            System.out.println("Lista nula");
        }

       model.addAttribute("listaEmpleados", lista);

        return "employee/lista";
    }



}
