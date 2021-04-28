package se.lexicon.petclinic_practice.service;

import se.lexicon.petclinic_practice.dto.OwnerDto;
import se.lexicon.petclinic_practice.exception.DataNotFoundException;

import java.util.List;

public interface OwnerService {
    OwnerDto save(OwnerDto dto);
    OwnerDto udate(OwnerDto dto) throws DataNotFoundException;
    OwnerDto findById(String id) throws DataNotFoundException;
    void deleteById(String id);
    List<OwnerDto>getAll();
    List<OwnerDto>advnceSearch(String firstName,String lastName);

}
