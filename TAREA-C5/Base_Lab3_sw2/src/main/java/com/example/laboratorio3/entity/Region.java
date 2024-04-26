package com.example.laboratorio3.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "regions")
public class Region {

    @Id
    private float regionId;
    @Column(name = "region_name")
    private String regionName;

}
