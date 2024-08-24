package com.handroid.vet_clinic.entity;

import com.handroid.vet_clinic.enums.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dogs")
public class DogEntity extends PetEntity {
    @Column(name = "size")
    private Size size;

    @Override
    public String toString() {
        return "\nPet {"
                + "id = " + getId()
                + ", type = " + getType()
                + ", sex = " + getSex().getValues()
                + ", age = " + getAge()
                + ", name = " + getName()
                + ", healthState = " + getHealthState()
                + ", size = " + getSize()
                + ", ownerName = " + getOwnerName()
                + ", registrationDate = " + getRegistrationDate().format(FORMATTER)
                + "}";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        DogEntity dog = (DogEntity) object;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }
}
