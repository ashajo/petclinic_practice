package se.lexicon.petclinic_practice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.petclinic_practice.dto.OwnerDto;
import se.lexicon.petclinic_practice.entity.Owner;
import se.lexicon.petclinic_practice.exception.DataNotFoundException;
import se.lexicon.petclinic_practice.repository.OwnerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService{
    OwnerRepository ownerRepository;
    ModelMapper modelMapper;

    @Autowired

    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OwnerDto save(OwnerDto dto) {
        if(dto==null) throw new IllegalArgumentException("OwnerDto object should not be null");
        if (dto.getId()!=null)throw new IllegalArgumentException("Id should be null");
        Owner ownerEntity=modelMapper.map(dto,Owner.class);
        Owner savedOwnerEntity=ownerRepository.save(ownerEntity);
        OwnerDto convertEntityToDto=modelMapper.map(savedOwnerEntity,OwnerDto.class);

        return convertEntityToDto;
    }

    @Override
    public OwnerDto udate(OwnerDto dto)throws DataNotFoundException {
        if (dto==null)throw new IllegalArgumentException("Owner object should not be null");
        if (dto.getId()==null)throw new IllegalArgumentException("Id should not be null");
        Optional<Owner>optionalOwner=ownerRepository.findById(dto.getId());
        if (optionalOwner.isPresent()) {
            return modelMapper.map(ownerRepository.save(modelMapper.map(dto, Owner.class)), OwnerDto.class);
        }else {
            throw new DataNotFoundException("OwnerDto not found");
        }
    }

    @Override
    public OwnerDto findById(String id)throws DataNotFoundException{
        if(id==null)throw new IllegalArgumentException("Id should not be null");
        Optional<Owner>optionalOwner=ownerRepository.findById(id);
        if (optionalOwner.isPresent()){
            OwnerDto convertedData=modelMapper.map(optionalOwner.get(),OwnerDto.class);
            return convertedData;
        }else{
            throw new DataNotFoundException("OwnerDto not found");
        }
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public List<OwnerDto> getAll() {
        List<Owner>ownerList=new ArrayList<>();
        ownerRepository.findAll().iterator().forEachRemaining(ownerList::add);
        List<OwnerDto>ownerDtoList=ownerList.stream()
                .map(owner -> modelMapper.map(owner,OwnerDto.class))
                .collect(Collectors.toList());
        return ownerDtoList;
    }

    @Override
    public List<OwnerDto> advnceSearch(String firstName, String lastName) {
        if (firstName!=null&&lastName!=null)return searchByFullName(firstName,lastName);
        else if (firstName!=null)return searchByFirstName(firstName);
        else if (lastName!=null)return searchByLastName(lastName);
        else return getAll();
}
private List<OwnerDto>searchByFirstName(String firstName){
    return ownerRepository.findByFirstNameIgnoreCase(firstName).stream().map(owner -> modelMapper.map(owner,OwnerDto.class)).collect(Collectors.toList());
    }
    private List<OwnerDto>searchByLastName(String lastName){
        return ownerRepository.findByLastNameIgnoreCase(lastName).stream().map(owner -> modelMapper.map(owner,OwnerDto.class)).collect(Collectors.toList());

    }
    private List<OwnerDto>searchByFullName(String firstName,String lastName){
        return ownerRepository.findByFirstNameIgnoreCaseAndlastNameIgnoreCase(firstName,lastName)
                .stream().map(owner -> modelMapper.map(owner,OwnerDto.class))
                .collect(Collectors.toList());
    }
}
