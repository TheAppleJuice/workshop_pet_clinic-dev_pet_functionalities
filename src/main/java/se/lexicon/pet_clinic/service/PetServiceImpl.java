package se.lexicon.pet_clinic.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.pet_clinic.dto.PetDto;
import se.lexicon.pet_clinic.entity.Pet;
import se.lexicon.pet_clinic.entity.String;
import se.lexicon.pet_clinic.exception.DataNotFoundException;
import se.lexicon.pet_clinic.repository.PetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        if (petDto == null) throw new IllegalArgumentException("PetDto should not be null");
        if (petDto.getId()==null) throw new IllegalArgumentException("Id should not be null");
        Optional<Pet> optionalPet = petRepository.findById(petDto.getId());
        if (optionalPet.isPresent()){
            Pet petEntity = modelMapper.map(petDto,Pet.class);
            Pet savedToPetEntity = petRepository.save(petEntity);
            PetDto convertPetEntityToDto = modelMapper.map(savedToPetEntity, PetDto.class);
            return convertPetEntityToDto;
        } else throw new DataNotFoundException("PetDto not found");

    }

    @Override
    public void delete(String id) throws DataNotFoundException {
        if (id == null) throw new IllegalArgumentException("Id should not be null");
        Optional<Pet> optionalPet = petRepository.findById(id);
        if (optionalPet.isPresent()){
            Pet petEntity = modelMapper.map(optionalPet,Pet.class);
            petRepository.delete(petEntity);
        }



    }

    @Override
    public List<PetDto> findAll() {
        List<Pet> petList = new ArrayList<>();
        petRepository.findAll().iterator().forEachRemaining(petList::add);
        List<PetDto> petDtoList = petList.stream().map(pet -> modelMapper.map(pet, PetDto.class)).collect(Collectors.toList());
        return petDtoList;
    }

    @Override
    public PetDto findById(String id) throws DataNotFoundException {
        if (id == null) throw new IllegalArgumentException("Id should not be null");
        Optional<Pet> optionalPet = petRepository.findById(id);
        if (optionalPet.isPresent()){
            PetDto convertToDto = modelMapper.map(optionalPet.get(), PetDto.class);
            return convertToDto;
        } else throw new DataNotFoundException("PetDto not found");

    }

    @Override
    public List<PetDto> findByName(String name) {
        return petRepository.findByNameIgnoreCase(name).stream().map(pet -> modelMapper.map(pet, PetDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PetDto> findByPetTypeName(String name) {
        return petRepository.findByPetTypeNameIgnoreCase(name).stream().map(pet -> modelMapper.map(pet, PetDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PetDto> findByOwnerFirstNameIgnoreCaseAndLastNameIgnoreCase(String fistName, String lastName) {
        return petRepository.findByOwner_FirstNameIgnoreCaseAndOwner_LastNameIgnoreCase(fistName, lastName).stream().map(pet -> modelMapper.map(pet,PetDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PetDto> findByOwnerTelephone(String telephone) {
        return petRepository.findByOwner_Telephone(telephone).stream().map(pet -> modelMapper.map(pet, PetDto.class)).collect(Collectors.toList());
    }
}
