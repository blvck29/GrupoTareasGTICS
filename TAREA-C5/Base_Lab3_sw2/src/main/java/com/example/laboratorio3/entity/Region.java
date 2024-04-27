package com.example.laboratorio3.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
