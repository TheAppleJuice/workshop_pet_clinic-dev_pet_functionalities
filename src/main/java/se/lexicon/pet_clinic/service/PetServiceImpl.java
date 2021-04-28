package se.lexicon.pet_clinic.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.pet_clinic.dto.PetDto;
import se.lexicon.pet_clinic.entity.Owner;
import se.lexicon.pet_clinic.entity.Pet;
import se.lexicon.pet_clinic.entity.String;
import se.lexicon.pet_clinic.exception.DataNotFoundException;
import se.lexicon.pet_clinic.repository.PetRepository;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    // todo: implement PetService Interface

    PetRepository petRepository;
    ModelMapper modelMapper;

    @Autowired
    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }



    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }




    @Override
    public PetDto save(PetDto petDto) {
        if (petDto== null) throw new IllegalArgumentException("petDto should not be null");
        if (petDto.getId()!= null) throw new IllegalArgumentException("Id should me null");
        Pet petEntity = modelMapper.map(petDto,Pet.class);
        Pet savedToPetEntity = petRepository.save(petEntity);
        PetDto convertPetEntityToDto = modelMapper.map(savedToPetEntity, PetDto.class);
        return convertPetEntityToDto;
    }

    @Override
    public PetDto update(PetDto petDto) throws DataNotFoundException {
        return null;
    }

    @Override
    public void delete(String id) throws DataNotFoundException {

    }

    @Override
    public List<PetDto> findAll() {
        return null;
    }

    @Override
    public PetDto findById(String id) throws DataNotFoundException {
        return null;
    }

    @Override
    public List<PetDto> findByName(String name) {
        return null;
    }

    @Override
    public List<PetDto> findByPetTypeName(String name) {
        return null;
    }

    @Override
    public List<PetDto> findByOwnerFirstNameAndLastName(String fistName, String lastName) {
        return null;
    }

    @Override
    public List<PetDto> findByOwnerTelephone(String telephone) {
        return null;
    }
}
