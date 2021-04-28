package se.lexicon.pet_clinic.repository;


import org.springframework.data.repository.CrudRepository;
import se.lexicon.pet_clinic.entity.Owner;
import se.lexicon.pet_clinic.entity.Pet;
import se.lexicon.pet_clinic.entity.PetType;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, String> {

    // todo: implement basic CRUD. Done

    //todo: select pet by name
    List<Pet> findPetByNameIgnoreCase (String name);
    //todo: select pet by pet type name
    List<Pet> findPetByPetTypeNameIgnoreCase (PetType name);
    //todo: select pet by owner first name and last name
    List<Pet> findPetByOwner_FirstNameIgnoreCaseAndOwner_LastNameIgnoreCase (Owner firstName, Owner lastName);
    //todo: select pet by owner telephone
    List<Pet> findPetByOwner_Telephone (Owner telephone);
}
