package se.lexicon.pet_clinic.dto;

import lombok.Data;
import se.lexicon.pet_clinic.entity.Owner;
import se.lexicon.pet_clinic.entity.String;
import se.lexicon.pet_clinic.repository.PetTypeRepository;

import java.time.LocalTime;

@Data
public class PetDto {
    // todo: implement PetDto
    private String id;
    private String name;
    private LocalTime birthDate;
    private PetTypeDto petTypeDto;
    private OwnerDto ownerDto;
}
