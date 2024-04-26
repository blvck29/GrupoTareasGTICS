package com.example.laboratorio3.repository;


import com.example.laboratorio3.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

}
