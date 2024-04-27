package com.example.laboratorio3.entity;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Countries {
    @Id
    private String country_id;

    @Column(name = "country_name")
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;


}
