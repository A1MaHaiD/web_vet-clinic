package com.handroid.vet_clinic.dto;

import com.handroid.vet_clinic.enums.Location;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientDto {
    private String firsName;
    private String lastName;
    private String email;
    private List<PetDto> petEntities = new ArrayList<>();
    private Location location;
}
