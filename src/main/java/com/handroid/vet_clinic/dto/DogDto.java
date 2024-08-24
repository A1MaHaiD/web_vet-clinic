package com.handroid.vet_clinic.dto;

import com.handroid.vet_clinic.enums.HealthState;
import com.handroid.vet_clinic.enums.Sex;
import com.handroid.vet_clinic.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DogDto extends PetDto {
    private Size size;

    @Override
    public String toString() {
        return "\nPet {" +
                "type = " + getType()
                + ", sex = " + getSex().getValues()
                + ", age = " + getAge()
                + ", name = " + getName()
                + ", healthState = " + getHealthState()
                + ", size = " + getSize()
                + ", ownerName = " + getOwnerName()
                + ", registrationDate = " + getRegistrationDate().format(FORMATTER)
                + "}";
    }

    public DogDto(String type, Sex sex, String age, String name, HealthState healthState, String ownerName, Size size) {
        super(type, sex, age, name, healthState, ownerName);
        this.size = size;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        DogDto dog = (DogDto) object;

        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }
}
