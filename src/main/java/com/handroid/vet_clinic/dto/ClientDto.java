package com.handroid.vet_clinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ClientDto {
    private Long id;
    private String firsName;
    private String lastName;
    private String email;
    private List<PetDto> pets;
    private LocationDto location;
}
