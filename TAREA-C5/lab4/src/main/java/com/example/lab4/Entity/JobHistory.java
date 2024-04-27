package com.example.lab4.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "job_history")
public class JobHistory {

    @Id
    private Integer job_history_id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employee;
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "end_date")
    private Date end_date;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
