package com.handroid.vet_clinic.entity;

import com.handroid.vet_clinic.enums.HealthState;
import com.handroid.vet_clinic.enums.Sex;
import com.handroid.vet_clinic.enums.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pets")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pet_type")
    private String petType;
    @Column(name = "pet_sex")
    private Sex petSex;
    @Column(name = "pet_age")
    private String petAge;
    @Column(name = "pet_size")
    private Size petSize;
    @Column(name = "pet_name")
    private String petName;
    @Column(name = "health_state")
    private HealthState healthState;
    @ManyToOne
    @JoinColumn(name = "username")
    private ClientEntity owner;
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;
}
