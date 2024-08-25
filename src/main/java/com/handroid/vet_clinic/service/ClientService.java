package com.handroid.vet_clinic.service;

import com.handroid.vet_clinic.dto.ClientDto;
import com.handroid.vet_clinic.entity.ClientEntity;
import com.handroid.vet_clinic.mapper.ClientMapper;
import com.handroid.vet_clinic.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService implements UserDetailsService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ClientDto loadUserByUsername(String username) throws UsernameNotFoundException {
        return clientMapper.mapEntityToDto(clientRepository.findUserClientEntityByUsername(username));
    }

    public List<ClientDto> loadAll() {
        List<ClientEntity> clientEntities = clientRepository.findAll();
        return clientMapper.mapEntityToDto(clientEntities);
    }

    public ClientDto saveClient(ClientDto clientDto) {
        ClientEntity saved = clientRepository.save(Objects.requireNonNull(clientMapper.mapDtoToEntity(clientDto)));
        return clientMapper.mapEntityToDto(saved);
    }

    public void deleteClient(String username) {
        clientRepository.deleteByUsername(username);
    }

    public ClientDto update(ClientDto customerDto) {
        if (customerDto.getUsername() == null) {
            throw new RuntimeException("Email required");
        }
        ClientEntity existing = clientRepository.findUserClientEntityByUsername(customerDto.getUsername());
        if (existing == null) {
            throw new RuntimeException("client not found");
        }
        //TODO тут може бути помилка
        Optional<ClientEntity> customerEntity = Optional.ofNullable(clientMapper.mapDtoToEntity(customerDto));
        BeanUtils.copyProperties(customerEntity, existing);
        clientRepository.save(existing);
        return clientMapper.mapEntityToDto(existing);
    }
}
