package se.lexicon.pet_clinic.service;

import se.lexicon.pet_clinic.dto.PetDto;
import se.lexicon.pet_clinic.entity.Owner;
import se.lexicon.pet_clinic.entity.String;
import se.lexicon.pet_clinic.exception.DataNotFoundException;

import java.util.List;

public interface PetService {

    // todo: define SAVE, UPDATE, DELETE, Find All, FIND BY ID, find By Name, find By PetTypeName, find By OwnerFirstNameAndLastName, find By OwnerTelephone

    PetDto save (PetDto petDto);
    PetDto update (PetDto petDto) throws DataNotFoundException;
    void delete (String id) throws DataNotFoundException;
    List <PetDto> findAll ();
    PetDto findById (String id)throws DataNotFoundException;
    List<PetDto> findByName (String name);
    List<PetDto> findByPetTypeName (String name);
    List<PetDto> findByOwnerFirstNameAndLastName (String fistName, String lastName);
    List<PetDto> findByOwnerTelephone (String telephone);
}
