package com.handroid.vet_clinic.controller;

import com.handroid.vet_clinic.dto.PetDto;
import com.handroid.vet_clinic.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController(PetController.BASE_PATH)
@RequiredArgsConstructor
public class PetController {
    public static final String BASE_PATH = "/v1/pets";
    private final PetService petService;

    @GetMapping
    @Secured({"ADMIN", "DOCTOR"})
    public List<PetDto> loadAllPet() {
        log.info("/pets loadAllPet");
        return petService.loadAll();
    }

    @GetMapping
    @Secured({"CLIENT"})
    public PetDto loadPet(Long id) {
        log.info("/pets/${id} loadPet", id);
        return petService.loadPetById(id);
    }

    @PostMapping
    @Secured({"CLIENT"})
    public PetDto createPet(@RequestBody PetDto petDto) {
        log.info("/pets/${petDto} createPet", petDto);
        return petService.savePet(petDto);
    }

    @PutMapping
    @Secured({"CLIENT", "DOCTOR"})
    public PetDto updatePet(@RequestBody PetDto petDto) {
        log.info("/pets/${petDto} updatePet", petDto);
        return petService.update(petDto);
    }

    @DeleteMapping
    @Secured({"CLIENT", "DOCTOR"})
    public void deletePet(Long id) {
        log.info("/pets/${id} deletePet", id);
        petService.deletePet(id);
    }
}
