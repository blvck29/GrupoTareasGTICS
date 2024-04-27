package com.example.laboratorio3.repository;



import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

    List<Employees> getEmployeesByJob(Job job);

    @Query(value = "SELECT MAX(em.employee_id) FROM employees em", nativeQuery = true)
    Integer findLastEmployeeId();

    //@Query(value="SELECT * FROM employees", nativeQuery= true )
   // List<Employees> ListaFiltrada(String word);

    @Query(value = "SELECT * FROM employees WHERE lower(first_name) LIKE lower(concat('%', ?1, '%'))", nativeQuery = true)
    List<Employees> ListaFiltrada(String word);





    @Query(value = "SELECT e.first_name AS Nombre, e.last_name AS Apellido, j.job_title AS Puesto, d.department_name AS Departamento, date(jh.start_Date) AS \"FechaInicio\" FROM job_history jh \n" +
            "LEFT JOIN jobs j ON jh.job_id = j.job_id \n" +
            "LEFT JOIN employees e ON e.employee_id = jh.employee_id \n" +
            "LEFT JOIN departments d ON d.department_id = jh.department_id\n" +
            "WHERE lower(e.first_name) LIKE lower(concat('%',?1,'%')) OR\n" +
            "lower(e.last_name) LIKE lower(concat('%',?1,'%')) OR\n" +
            "lower(j.job_title) LIKE lower(concat('%',?1,'%')) OR\n" +
            "lower(d.department_name) LIKE lower(concat('%',?1,'%'))", nativeQuery = true)
    List<EmpleadoHistoriaDTO> listaHistoriaEmpleado(String busqueda);

    @Query(value = "SELECT e.firstName, e.lastName, jh.start_date, jh.end_date, j.jobTitle FROM JobHistory jh JOIN jh.employee e JOIN jh.job j WHERE e.salary > 15000")
    List<Employees> findEmployeesWithHighSalary();


}
