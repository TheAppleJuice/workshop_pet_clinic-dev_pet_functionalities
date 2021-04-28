package se.lexicon.pet_clinic.dto;

import se.lexicon.pet_clinic.entity.Owner;
import se.lexicon.pet_clinic.entity.PetType;

import java.time.LocalTime;

public class PetDto {
    // todo: implement PetDto
    private String id;
    private String name;
    private LocalTime birthDate;
    private PetType petType;
    private Owner owner;
}
