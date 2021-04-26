package se.lexicon.petclinic_practice.entity;

import lombok.Data;

@Data
public class Owner {
    private String id;
    private String firstName;
    private String latName;
    private String address;
    private String telephone;
}
