package com.handroid.vet_clinic.controller;

import com.handroid.vet_clinic.dto.ClientDto;
import com.handroid.vet_clinic.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Slf4j
@RestController(ClientController.BASE_PATH)
@RequiredArgsConstructor
public class ClientController {
    public static final String BASE_PATH = "/v1/clients";
    private final ClientService clientService;

    @GetMapping
    @Secured({"ADMIN", "DOCTOR"})
    public List<ClientDto> loadAllClient() {
        log.info("/clients loadAllClient");
        return clientService.loadAll();
    }

    @GetMapping
    @Secured({"CLIENT"})
    public ClientDto loadClient(String mail) {
        log.info("/clients/${mail} loadClient", mail);
        return clientService.loadUserByUsername(mail);
    }

    @PostMapping
    @Secured({"CLIENT"})
    public ClientDto createClient(@RequestBody ClientDto clientDto) {
        log.info("/clients/${clientDto} createClient", clientDto);
        return clientService.saveClient(clientDto);
    }

    @PutMapping
    @Secured({"CLIENT"})
    public ClientDto updateClient(@RequestBody ClientDto clientDto) {
        log.info("/clients/${clientDto} updateClient", clientDto);
        return clientService.update(clientDto);
    }

    @DeleteMapping
    @Secured({"CLIENT"})
    public void deleteClient(String mail) {
        log.info("/clients/${mail} deleteClient", mail);
        clientService.deleteClient(mail);
    }
}
