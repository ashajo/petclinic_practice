package se.lexicon.petclinic_practice.entity;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Pet {
    private String id;
    private String name;
    private LocalDate birthDate;
    private PetType petType;
    private Owner owner;
}
