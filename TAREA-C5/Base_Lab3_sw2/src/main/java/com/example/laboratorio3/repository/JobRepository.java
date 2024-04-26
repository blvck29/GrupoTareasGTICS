package com.example.laboratorio3.repository;

import com.example.lab4.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

}
