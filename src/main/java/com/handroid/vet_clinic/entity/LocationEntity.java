package com.handroid.vet_clinic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "locations")
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "location_name")
    private String locationName;
    @Column(name = "clients")
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<ClientEntity> clients;
}
