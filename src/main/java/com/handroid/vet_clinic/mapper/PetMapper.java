package com.handroid.vet_clinic.mapper;

import com.handroid.vet_clinic.dto.PetDto;
import com.handroid.vet_clinic.entity.PetEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class PetMapper implements Mapper<PetEntity, PetDto> {

    private final ClientMapper clientMapper;

    @Override
    public PetDto mapEntityToDto(PetEntity source) throws RuntimeException {
        if (isNull(source)) {
            return null;
        }
        PetDto target = new PetDto();
        target.setId(source.getId());
        target.setPetType(source.getPetType());
        target.setPetSex(source.getPetSex());
        target.setPetAge(source.getPetAge());
        target.setPetSize(source.getPetSize());
        target.setPetName(source.getPetName());
        target.setHealthState(source.getHealthState());
        target.setOwnerName(clientMapper.mapEntityToDto(source.getOwnerName()));
        target.setRegistrationDate(source.getRegistrationDate());
        return target;
    }

    @Override
    public PetEntity mapDtoToEntity(PetDto source) throws RuntimeException {
        if (isNull(source)) {
            return null;
        }
        PetEntity target = new PetEntity();
        target.setId(source.getId());
        target.setPetType(source.getPetType());
        target.setPetSex(source.getPetSex());
        target.setPetAge(source.getPetAge());
        target.setPetSize(source.getPetSize());
        target.setPetName(source.getPetName());
        target.setHealthState(source.getHealthState());
        target.setOwnerName(clientMapper.mapDtoToEntity(source.getOwnerName()));
        target.setRegistrationDate(source.getRegistrationDate());
        return target;
    }
}
