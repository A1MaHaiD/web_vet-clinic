package com.handroid.vet_clinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class LocationDto {
    private Long id;
    private String locationName;
    private List<ClientDto> clients;
}
