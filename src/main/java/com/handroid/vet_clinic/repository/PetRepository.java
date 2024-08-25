package com.handroid.vet_clinic.repository;

import com.handroid.vet_clinic.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {
    PetEntity findPetById(Long id);
}
