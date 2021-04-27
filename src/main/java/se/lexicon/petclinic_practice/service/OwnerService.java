package se.lexicon.petclinic_practice.service;

import se.lexicon.petclinic_practice.dto.OwnerDto;

import java.util.List;

public interface OwnerService {
    OwnerDto save(OwnerDto dto);
    OwnerDto udate(OwnerDto dto);
    OwnerDto findById(OwnerDto dto);
    void deleteById(String id);
    List<OwnerDto>getAll();
    List<OwnerDto>advnceSearch(String firstName,String lastName);

}
