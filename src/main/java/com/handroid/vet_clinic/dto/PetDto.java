package com.handroid.vet_clinic.dto;

import com.handroid.vet_clinic.enums.HealthState;
import com.handroid.vet_clinic.enums.Sex;
import com.handroid.vet_clinic.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class PetDto {
    private Long id;
    private String petType;
    private Sex petSex;
    private String petAge;
    private Size petSize;
    private String petName;
    private HealthState healthState;
    private ClientDto ownerName;
    private LocalDateTime registrationDate;
}
