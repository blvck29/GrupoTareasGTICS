package com.example.laboratorio3.repository;


import com.example.laboratorio3.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmetRepository extends JpaRepository<Department, Integer> {

}

