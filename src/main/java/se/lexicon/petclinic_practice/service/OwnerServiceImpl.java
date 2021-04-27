package se.lexicon.petclinic_practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.petclinic_practice.dto.OwnerDto;
import se.lexicon.petclinic_practice.repository.OwnerRepository;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService{
    OwnerRepository ownerRepository;

    @Autowired

    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public OwnerDto save(OwnerDto dto) {
        return null;
    }

    @Override
    public OwnerDto udate(OwnerDto dto) {
        return null;
    }

    @Override
    public OwnerDto findById(OwnerDto dto) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public List<OwnerDto> getAll() {
        return null;
    }

    @Override
    public List<OwnerDto> advnceSearch(String firstName, String lastName) {
        return null;
    }
}
