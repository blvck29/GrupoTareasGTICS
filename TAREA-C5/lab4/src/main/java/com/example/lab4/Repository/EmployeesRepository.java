package com.example.lab4.Repository;


import com.example.lab4.Entity.Employees;
import com.example.lab4.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

    List<Employees> getEmployeesByJob(Job job);

}
