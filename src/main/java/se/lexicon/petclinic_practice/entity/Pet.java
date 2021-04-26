package se.lexicon.petclinic_practice.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
public class Pet {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    private LocalDate birthDate;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "pet_type_id")
    private PetType petType;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
