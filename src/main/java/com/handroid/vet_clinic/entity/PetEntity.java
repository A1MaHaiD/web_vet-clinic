package com.handroid.vet_clinic.entity;

import com.handroid.vet_clinic.enums.HealthState;
import com.handroid.vet_clinic.enums.Sex;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pets")
public abstract class PetEntity {
    //TODO this row
    static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "sex")
    private Sex sex;
    @Column(name = "age")
    private String age;
    @Column(name = "name")
    private String name;
    @Column(name = "health_state")
    //TODO this row
    private HealthState healthState;
    @Column(name = "owner_name")
    private String ownerName;
    //TODO this row
    @Column(name = "registration_date")
    private final LocalDateTime registrationDate = LocalDateTime.now();

    @Override
    public String toString() {
        return "\nPet {"
                + "id = " + id
                + ", type = " + type
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
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        PetEntity petEntity = (PetEntity) object;
        return Objects.equals(type, petEntity.type)
                && Objects.equals(sex, petEntity.sex)
                && Objects.equals(age, petEntity.age)
                && Objects.equals(name, petEntity.name)
                && Objects.equals(healthState, petEntity.healthState)
                && Objects.equals(ownerName, petEntity.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, healthState, ownerName);
    }
}
