package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.entity.PersonEntity;
import one.digitalinnovation.personapi.model.PersonRequest;
import one.digitalinnovation.personapi.model.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "id", ignore = true)
    PersonEntity toPersonEntity(PersonRequest personRequest);

    PersonResponse toPersonResponse(PersonEntity personEntity);
}

