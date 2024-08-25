package com.handroid.vet_clinic.service.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientAuthority implements GrantedAuthority {

    private String role;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return role;
    }
}
