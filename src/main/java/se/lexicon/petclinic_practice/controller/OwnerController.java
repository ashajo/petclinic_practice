package se.lexicon.petclinic_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.petclinic_practice.dto.OwnerDto;
import se.lexicon.petclinic_practice.exception.DataNotFoundException;
import se.lexicon.petclinic_practice.service.OwnerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owner")
public class OwnerController {
    OwnerService ownerService;
@Autowired
    public void setOwnerService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @GetMapping
    public ResponseEntity<List<OwnerDto>>getAll(){
    List<OwnerDto>ownerDtoList=ownerService.getAll();
    return ResponseEntity.ok(ownerDtoList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OwnerDto>findById(@PathVariable("id")String id){
    if (id==null)return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    try {
        OwnerDto dto = ownerService.findById(id);
        return ResponseEntity.ok(dto);
    }catch (DataNotFoundException e){
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    }
    @PostMapping
    public ResponseEntity<OwnerDto>save(@RequestBody OwnerDto ownerDto){
    if (ownerDto!=null)
        if (ownerDto.getId()!=null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        OwnerDto result=ownerService.save(ownerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping("/search")
    public ResponseEntity<List<OwnerDto>>advnceSearch(
            @RequestParam(value = "firstName",required = false)String firstName,
            @RequestParam(value = "lastName",required = false)String lastName){
    List<OwnerDto>ownerDtoList=ownerService.advnceSearch(firstName,lastName);
    return ResponseEntity.ok(ownerDtoList);

    }


}
