package com.handroid.vet_clinic.dto;

import com.handroid.vet_clinic.service.auth.ClientAuthority;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@ToString
@Getter
@Setter
public class ClientDto implements UserDetails {
    private Long id;
    private String firsName;
    private String lastName;
    private String username;
    private String password;
    private List<PetDto> pets;
    private LocationDto location;
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialsNonExpired;
    private Boolean isEnabled;
    private List<ClientAuthority> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
