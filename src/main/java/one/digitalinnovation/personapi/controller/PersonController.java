package one.digitalinnovation.personapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "PersonController", description = "Methods used to process people's data")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Operation(summary = "Add Person", description = "", tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Person successfully added",
                    content = @Content(schema = @Schema(implementation = PersonRequest.class))
            )
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponse createPerson(@Valid @RequestBody PersonRequest personRequest) {
        return personService.createPerson(personRequest);
    }

    @Operation(summary = "List all Person", description = "", tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Everyone successfully lists",
                    content = @Content(schema = @Schema(implementation = PersonResponse.class))
            )
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonResponse> listAll() {
        return personService.getListAll();
    }

    @Operation(summary = "Person list by id", description = "", tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person found",
                    content = @Content(schema = @Schema(implementation = PersonResponse.class))
            )
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonResponse findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @Operation(summary = "Changes person data", description = "", tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Changed data",
                    content = @Content(schema = @Schema(implementation = PersonResponse.class))
            )
    })
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public MessagemResponse updateById(@PathVariable Long id, @RequestBody PersonRequest personRequest)
            throws PersonNotFoundException {
        return personService.updateById(id, personRequest);
    }

    @Operation(summary = "Remove person", description = "", tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Removes person successfully")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.deleteById(id);
    }
}
