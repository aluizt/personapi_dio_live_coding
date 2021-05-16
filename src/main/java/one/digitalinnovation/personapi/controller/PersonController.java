package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.model.MessagemResponse;
import one.digitalinnovation.personapi.model.PersonRequest;
import one.digitalinnovation.personapi.model.PersonResponse;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponse createPerson(@Valid @RequestBody PersonRequest personRequest) {
        return personService.createPerson(personRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonResponse> listAll() {
        return personService.getListAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonResponse findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public MessagemResponse updateById(@PathVariable Long id, @RequestBody PersonRequest personRequest)
            throws PersonNotFoundException {
        return personService.updateById(id, personRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.deleteById(id);
    }
}
