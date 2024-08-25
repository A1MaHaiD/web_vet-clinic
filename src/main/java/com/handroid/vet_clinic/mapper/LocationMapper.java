package com.handroid.vet_clinic.mapper;

import com.handroid.vet_clinic.dto.LocationDto;
import com.handroid.vet_clinic.entity.LocationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public final class LocationMapper implements Mapper<LocationEntity, LocationDto> {

    private final ClientMapper clientMapper;

    @Override
    public LocationDto mapEntityToDto(LocationEntity source) throws RuntimeException {
        if (isNull(source)) {
            return null;
        }
        LocationDto target = new LocationDto();
        target.setId(source.getId());
        target.setLocationName(source.getLocationName());
        target.setClients(clientMapper.mapEntityToDto(source.getClients()));
        return target;
    }

    @Override
    public LocationEntity mapDtoToEntity(LocationDto source) throws RuntimeException {
        if (isNull(source)) {
            return null;
        }
        LocationEntity target = new LocationEntity();
        target.setId(source.getId());
        target.setLocationName(source.getLocationName());
        target.setClients(clientMapper.mapDtoToEntity(source.getClients()));
        return target;
    }
}
