package se.lexicon.pet_clinic.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.pet_clinic.dto.PetTypeDto;
import se.lexicon.pet_clinic.entity.PetType;
import se.lexicon.pet_clinic.exception.DataNotFoundException;
import se.lexicon.pet_clinic.repository.PetTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetTypeServiceImpl implements PetTypeService {
    // todo: implement PetTypeService Interface


    PetTypeRepository petTypeRepository;
    ModelMapper modelMapper;

    @Autowired
    public void setPetTypeRepository(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public PetTypeDto save(PetTypeDto petTypeDto) {
        if (petTypeDto == null) throw new IllegalArgumentException("petTypeDto should not be null");
        if (petTypeDto.getId() != 0) throw new IllegalArgumentException("Id should be null");
        PetType petTypeEntity = modelMapper.map(petTypeDto, PetType.class);
        PetType savedPetTypeEntity = petTypeRepository.save(petTypeEntity);
        PetTypeDto convertPetTypeEntityToDto = modelMapper.map(savedPetTypeEntity, PetTypeDto.class);
        return convertPetTypeEntityToDto;
    }

    @Override
    public PetTypeDto update(PetTypeDto petTypeDto) throws DataNotFoundException {
        if (petTypeDto == null) throw new IllegalArgumentException("PetTypeDto should not be null");
        if (petTypeDto.getId() == 0) throw new IllegalArgumentException("ID should not be null");
        Optional<PetType> optionalPetType = petTypeRepository.findById(petTypeDto.getId());
        if (optionalPetType.isPresent()) {
            PetType petTypeEntity = modelMapper.map(petTypeDto, PetType.class);
            PetType savedPetTypeEntity = petTypeRepository.save(petTypeEntity);
            PetTypeDto convertPetTypeEntityToDto = modelMapper.map(savedPetTypeEntity, PetTypeDto.class);
            return convertPetTypeEntityToDto;
        } else throw new DataNotFoundException("PetTypeDto not found");

    }

    @Override
    public void delete(int id) {
        if (id == 0) throw new IllegalArgumentException("Id should not be null");
        Optional<PetType> optionalPetType = petTypeRepository.findById(id);
        if (optionalPetType.isPresent()) {
            PetType petTypeEntity = modelMapper.map(optionalPetType, PetType.class);
            petTypeRepository.delete(petTypeEntity);
        }

    }

    @Override
    public List<PetTypeDto> findAll() {
        List<PetType> petTypeList = new ArrayList<>();
        petTypeRepository.findAll().iterator().forEachRemaining(petTypeList::add);
        List<PetTypeDto> petTypeDtoList = petTypeList.stream().map(petType -> modelMapper.map(petType, PetTypeDto.class)).collect(Collectors.toList());
        return petTypeDtoList;
    }

    @Override
    public PetTypeDto findById(int id) throws DataNotFoundException {
        if (id == 0) throw new IllegalArgumentException("Id should not be null");
        Optional<PetType> optionalPetType = petTypeRepository.findById(id);
        if (optionalPetType.isPresent()) {
            PetTypeDto convetToDto = modelMapper.map(optionalPetType.get(), PetTypeDto.class);
            return convetToDto;
        } else throw new DataNotFoundException("PetTypeDto not found");

    }
}
