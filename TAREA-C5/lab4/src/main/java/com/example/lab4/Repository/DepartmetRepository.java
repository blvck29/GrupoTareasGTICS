package com.example.lab4.Repository;

import com.example.lab4.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmetRepository extends JpaRepository<Department, Integer> {

}

