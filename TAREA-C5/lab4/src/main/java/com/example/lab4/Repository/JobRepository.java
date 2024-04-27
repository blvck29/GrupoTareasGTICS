package com.example.lab4.Repository;

import com.example.lab4.Entity.Employees;
import com.example.lab4.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

}
