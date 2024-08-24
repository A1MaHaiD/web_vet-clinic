package com.handroid.vet_clinic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HealthState {
    UNKNOWN(0), EMERGENCY(1), BAD(2), NORMAL(3),
    GOOD(4), WELL(5), VERY_WELL(6);
    private final int value;
}
