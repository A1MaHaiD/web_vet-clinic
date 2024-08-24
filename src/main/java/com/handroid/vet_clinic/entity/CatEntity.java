package com.handroid.vet_clinic.entity;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cats")
public class CatEntity extends PetEntity {

}
