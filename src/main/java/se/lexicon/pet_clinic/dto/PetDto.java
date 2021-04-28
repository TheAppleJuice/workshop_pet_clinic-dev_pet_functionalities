package se.lexicon.pet_clinic.dto;

import lombok.Data;
import se.lexicon.pet_clinic.entity.Owner;
import se.lexicon.pet_clinic.entity.String;

import java.time.LocalTime;

@Data
public class PetDto {
    // todo: implement PetDto
    private java.lang.String id;
    private java.lang.String name;
    private LocalTime birthDate;
    private String string;
    private Owner owner;
}
