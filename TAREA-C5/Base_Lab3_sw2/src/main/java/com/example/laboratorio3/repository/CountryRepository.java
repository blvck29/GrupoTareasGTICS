package com.example.laboratorio3.repository;

import com.example.laboratorio3.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Countries, String> {
    @Query("SELECT c.countryName AS countryName, l.city AS city, COUNT(DISTINCT d.departmentId) AS numberOfDepartments " +
            "FROM Countries c " +
            "JOIN c.region r " +
            "JOIN Location l ON l.country = c " +
            "JOIN Department d ON d.location = l " +
            "JOIN Employees e ON e.department = d " +
            "GROUP BY c.countryName, l.city " +
            "HAVING COUNT(e.employee_id) > 3")
    List<CountryCityDepartmentsProjection> findDepartmentsWithMoreThanThreeEmployees();
}
