package se.lexicon.pet_clinic.repository;


import org.springframework.data.repository.CrudRepository;
import se.lexicon.pet_clinic.entity.Owner;
import se.lexicon.pet_clinic.entity.Pet;
import se.lexicon.pet_clinic.entity.String;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, String> {

    // todo: implement basic CRUD. Done

    //todo: select pet by name
    List<Pet> findByNameIgnoreCase(String name);
    //todo: select pet by pet type name
    List<Pet> findByPetTypeNameIgnoreCase (String petTypeName);
    //todo: select pet by owner first name and last name
    List<Pet> findByOwner_FirstNameIgnoreCaseAndOwner_LastNameIgnoreCase(String firstName, String lastName);
    //todo: select pet by owner telephone
    List<Pet> findByOwner_Telephone (String telephone);
}
