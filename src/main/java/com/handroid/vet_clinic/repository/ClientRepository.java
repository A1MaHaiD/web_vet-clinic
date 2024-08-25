package com.handroid.vet_clinic.repository;

import com.handroid.vet_clinic.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    //TODO: add other necessary methods
    ClientEntity findUserClientEntityByUsername(String username);
    void deleteByUsername(String username);
}
