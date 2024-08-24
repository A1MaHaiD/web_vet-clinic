package com.handroid.vet_clinic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sex {
    MALE("male"), FEMALE("female");
    private final String values;
}
