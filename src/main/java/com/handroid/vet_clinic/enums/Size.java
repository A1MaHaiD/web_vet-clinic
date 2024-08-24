package com.handroid.vet_clinic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Size {
    XS(1), S(2), M(3), L(4), XL(5), UNKNOWN(0);
    private final int values;
}
