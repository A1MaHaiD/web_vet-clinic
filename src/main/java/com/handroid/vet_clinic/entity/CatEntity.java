package com.handroid.vet_clinic.entity;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Table(name = "cats")
public class CatEntity extends PetEntity {

}
