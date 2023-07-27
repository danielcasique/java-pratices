package org.casique.validators;

import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * this code is provided by chatGPT
 */
@Mapper
public interface PersonMapper {
  PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

  @Mapping(target = "name", source = "name")
  @Mapping(target = "age", source = "age")
  @Valid
  PersonDto toDto(@Valid Person person);

  default PersonDto toDtoWithValidation(@Valid Person person) {
    return toDto(person);
  }
}

