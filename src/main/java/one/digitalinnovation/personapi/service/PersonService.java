package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.entity.PersonEntity;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.model.MessagemResponse;
import one.digitalinnovation.personapi.model.PersonRequest;
import one.digitalinnovation.personapi.model.PersonResponse;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonResponse createPerson(PersonRequest personRequest) {
        return personMapper.toPersonResponse(personRepository.save(personMapper.toPersonEntity(personRequest)));
    }

    public List<PersonResponse> getListAll() {
        List<PersonEntity> allPerson = personRepository.findAll();
        return allPerson.stream().map(personMapper::toPersonResponse).collect(Collectors.toList());
    }

    public PersonResponse findById(@PathVariable Long id) throws PersonNotFoundException {
        return personMapper.toPersonResponse(verifyIfExists(id));
    }

    public MessagemResponse updateById(Long id, PersonRequest personRequest) throws PersonNotFoundException {
        verifyIfExists(id);
        PersonEntity updatePerson = personRepository.save(addPersonId(personRequest, id));
        return createMessageResponse(updatePerson.getId(), "Update person with ID ");
    }

    public void deleteById(Long id) throws PersonNotFoundException {
        personRepository.deleteById(verifyIfExists(id).getId());
    }

    private PersonEntity verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessagemResponse createMessageResponse(Long id, String msg) {
        return MessagemResponse.builder()
                .msg(msg.concat(String.valueOf(id)))
                .build();
    }

    private PersonEntity addPersonId(PersonRequest personRequest, Long id) {
        PersonEntity personEntity = personMapper.toPersonEntity(personRequest);
        personEntity.setId(id);
        return personEntity;
    }
}
