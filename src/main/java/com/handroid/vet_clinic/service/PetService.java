package com.handroid.vet_clinic.service;

import com.handroid.vet_clinic.dto.PetDto;
import com.handroid.vet_clinic.entity.PetEntity;
import com.handroid.vet_clinic.mapper.PetMapper;
import com.handroid.vet_clinic.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetMapper petMapper;
    private final PetRepository petRepository;

    public PetDto loadPetById(Long id) {
        return petMapper.mapEntityToDto(petRepository.findPetById(id));
    }

    public List<PetDto> loadAll() {
        List<PetEntity> petEntities = petRepository.findAll();
        return petMapper.mapEntityToDto(petEntities);
    }

    public PetDto savePet(PetDto petDto) {
        PetEntity saved = petRepository.save(Objects.requireNonNull(petMapper.mapDtoToEntity(petDto)));
        return petMapper.mapEntityToDto(saved);
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    public PetDto update(PetDto petDto) {
        if (petDto.getId() == null) {
            throw new RuntimeException("ID required");
        }
        PetEntity existing = petRepository.findPetById(petDto.getId());
        if (existing == null) {
            throw new RuntimeException("pet not found");
        }
        //TODO тут може бути помилка
        Optional<PetEntity> petEntity = Optional.ofNullable(petMapper.mapDtoToEntity(petDto));
        BeanUtils.copyProperties(petEntity, existing);
        petRepository.save(existing);
        return petMapper.mapEntityToDto(existing);
    }
}
