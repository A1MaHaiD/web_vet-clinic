package com.handroid.vet_clinic.dto;

import com.handroid.vet_clinic.enums.HealthState;
import com.handroid.vet_clinic.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class PetDto {

    static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
    private String type;
    private Sex sex;
    private String age;
    private String name;
    private HealthState healthState;
    private String ownerName;

    private final LocalDateTime registrationDate = LocalDateTime.now();

    @Override
    public String toString() {
        return "\nPet {" +
                "type = " + type
                + ", sex = " + sex.getValues()
                + ", age = " + age
                + ", name = " + name
                + ", healthState = " + healthState
                + ", ownerName = " + ownerName
                + ", registrationDate = " + registrationDate.format(FORMATTER)
                + "}";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PetDto petDto = (PetDto) object;

        return Objects.equals(type, petDto.type)
                && Objects.equals(sex, petDto.sex)
                && Objects.equals(age, petDto.age)
                && Objects.equals(name, petDto.name)
                && Objects.equals(healthState, petDto.healthState)
                && Objects.equals(ownerName, petDto.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, healthState, ownerName);
    }
}
