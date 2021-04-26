package se.lexicon.petclinic_practice.entity;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Visit {
    private String id;
    private Pet pet;
    private LocalDate visitDate;
    private String description;
}
