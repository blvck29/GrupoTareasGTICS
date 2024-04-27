package com.example.lab4.Controller;

import com.example.lab4.Entity.Department;
import com.example.lab4.Entity.Employees;
import com.example.lab4.Entity.Job;
import com.example.lab4.Repository.DepartmetRepository;
import com.example.lab4.Repository.EmployeesRepository;
import com.example.lab4.Repository.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LabController {

    private final DepartmetRepository departmetRepository;
    private final JobRepository jobRepository;
    private final EmployeesRepository employeesRepository;

    public LabController(DepartmetRepository departmetRepository, JobRepository jobRepository, EmployeesRepository employeesRepository) {
        this.departmetRepository = departmetRepository;
        this.jobRepository = jobRepository;
        this.employeesRepository = employeesRepository;
    }

    @GetMapping(value = "/recursos_humanos")
    public String mainPage(){
        return "recursos_humanos";
    }

    @GetMapping(value = "/recursos_humanos/reportes")
    public String reportes(){
        return "reportes";
    }

    @GetMapping(value = "/recursos_humanos/reportes/sueldos")
    public String reporteSueldos(Model model){

        List<Job> listaJobs = jobRepository.findAll();
        List<String> salaryTotal = new ArrayList<>();
        List<String> meanSalary = new ArrayList<>();

        for (Job job : listaJobs) {
            List<Employees> listaEmpleadosPorJob = employeesRepository.getEmployeesByJob(job);

            double cantidadEmpleados = listaEmpleadosPorJob.size();
            double counterSalaryTotal = 0;

            for (Employees em : listaEmpleadosPorJob){
                double eachSalary = em.getSalary();
                counterSalaryTotal = counterSalaryTotal + eachSalary;
            }

            salaryTotal.add(String.valueOf(counterSalaryTotal));

            if (counterSalaryTotal != 0) {
                meanSalary.add(String.valueOf(counterSalaryTotal/cantidadEmpleados));
            } else {
                meanSalary.add("0.00");
            }

        }

        model.addAttribute("listaJobs", listaJobs);
        model.addAttribute("salaryTotal", salaryTotal);
        model.addAttribute("meanSalary", meanSalary);

        return "reportes/sueldos";
    }

    @GetMapping(value = "/recursos_humanos/reportes/empleados")
    public String reporteEmpleados(){
        return "reportes/empleados";
    }

}
