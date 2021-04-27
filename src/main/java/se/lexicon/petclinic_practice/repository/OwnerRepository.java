package se.lexicon.petclinic_practice.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.petclinic_practice.entity.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner,String> {
    List<Owner>findByAddressContains(String adress);
    List<Owner>findByTelephone(String telephone);
    List<Owner>findByFirstNameIgnoreCase(String firstName);
    List<Owner>findByLastNameIgnoreCase(String lastName);
    List<Owner>findByFirstNameIgnoreCaseAndlastNameIgnoreCase(String firstName,String lastName);
}
