package com.handroid.vet_clinic.mapper;

import com.handroid.vet_clinic.dto.ClientDto;
import com.handroid.vet_clinic.entity.ClientEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public final class ClientMapper implements Mapper<ClientEntity, ClientDto> {

    private final PetMapper petMapper;
    private final LocationMapper locationMapper;

    @Override
    public ClientDto mapEntityToDto(ClientEntity source) throws RuntimeException {
        if (isNull(source)) {
            return null;
        }
        ClientDto target = new ClientDto();
        target.setId(source.getId());
        target.setFirsName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setUsername(source.getUsername());
        target.setPassword(source.getPassword());
        target.setPets(petMapper.mapEntityToDto(source.getPets()));
        target.setLocation(locationMapper.mapEntityToDto(source.getLocation()));
        return target;
    }

    @Override
    public ClientEntity mapDtoToEntity(ClientDto source) throws RuntimeException {
        if (isNull(source)) {
            return null;
        }
        ClientEntity target = new ClientEntity();
        target.setId(source.getId());
        target.setFirstName(source.getFirsName());
        target.setLastName(source.getLastName());
        target.setUsername(source.getUsername());
        target.setPassword(source.getPassword());
        target.setPets(petMapper.mapDtoToEntity(source.getPets()));
        target.setLocation(locationMapper.mapDtoToEntity(source.getLocation()));
        return target;
    }
}
