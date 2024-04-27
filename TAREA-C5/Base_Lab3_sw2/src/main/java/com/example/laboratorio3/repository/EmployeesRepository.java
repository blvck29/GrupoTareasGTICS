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



}
