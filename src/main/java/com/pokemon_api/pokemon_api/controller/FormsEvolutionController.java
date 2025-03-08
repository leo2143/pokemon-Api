package com.pokemon_api.pokemon_api.controller;

import com.pokemon_api.pokemon_api.dto.FormEvolutionDto;
import com.pokemon_api.pokemon_api.dto.create.FormEvolutionCreateDto;
import com.pokemon_api.pokemon_api.dto.update.FormEvolutionUpdateDto;
import com.pokemon_api.pokemon_api.i18n.I18nCodes;
import com.pokemon_api.pokemon_api.services.FormEvolutionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("forms-evolutions")
@RestController
@AllArgsConstructor
@Tag(name = "Forms Evolutions Api", description = "Api orientada a brindar informacion las formas de evolucion")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class FormsEvolutionController {

    private final FormEvolutionService service;

    @PostMapping("")
    @Operation(summary = "#{" + I18nCodes.API_FORM_EVOLUTION_POST_SUMMARY + "}", description = "#{" + I18nCodes.API_FORM_EVOLUTION_POST_DESCRIPTION + "}")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "#{" + I18nCodes.API_RESPONSE_CREATED + "}", content = @Content(schema = @Schema(implementation = FormEvolutionDto.class))), @ApiResponse(responseCode = "404", description = "#{" + I18nCodes.API_RESPONSE_NOT_FOUND + "}"), @ApiResponse(responseCode = "500", description = "#{" + I18nCodes.API_RESPONSE_INTERNAL_SERVER_ERROR + "}")})
    public ResponseEntity<?> create(@RequestBody FormEvolutionCreateDto create) {
        return this.service.create(create);
    }

    @PutMapping("")
    @Operation(summary = "#{" + I18nCodes.API_FORM_EVOLUTION_PUT_SUMMARY + "}", description = "#{" + I18nCodes.API_FORM_EVOLUTION_PUT_DESCRIPTION + "}")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "#{" + I18nCodes.API_RESPONSE_CREATED + "}", content = @Content(schema = @Schema(implementation = FormEvolutionDto.class))), @ApiResponse(responseCode = "404", description = "#{" + I18nCodes.API_RESPONSE_NOT_FOUND + "}"), @ApiResponse(responseCode = "500", description = "#{" + I18nCodes.API_RESPONSE_INTERNAL_SERVER_ERROR + "}")})
    public ResponseEntity<?> update(@RequestBody FormEvolutionUpdateDto update) {
        return service.update(update, update.getId());
    }


    @GetMapping("")
    @Operation(summary = "#{" + I18nCodes.API_FORM_EVOLUTION_GET_ALL_SUMMARY + "}", description = "#{" + I18nCodes.API_FORM_EVOLUTION_GET_ALL_DESCRIPTION + "}")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "#{" + I18nCodes.API_RESPONSE_CREATED + "}"), @ApiResponse(responseCode = "404", description = "#{" + I18nCodes.API_RESPONSE_NOT_FOUND + "}"), @ApiResponse(responseCode = "500", description = "#{" + I18nCodes.API_RESPONSE_INTERNAL_SERVER_ERROR + "}")})
    @Parameter(name = "page", in = ParameterIn.QUERY, schema = @Schema(type = "integer", defaultValue = "0", example = "1"))
    @Parameter(name = "size", in = ParameterIn.QUERY, schema = @Schema(type = "integer", defaultValue = "0", example = "10"))
    @Parameter(name = "sort", in = ParameterIn.QUERY, array = @ArraySchema(schema = @Schema(type = "string")))
    public ResponseEntity<?> findAll(
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "size", required = false) Integer size,
            @RequestParam(name = "sort", required = false) Sort sort
    ) {
        Pageable pageable = PageRequest.of(page, size, sort != null ? sort : Sort.by("id"));
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "#{" + I18nCodes.API_FORM_EVOLUTION_GET_BY_ID_SUMMARY + "}", description = "#{" + I18nCodes.API_FORM_EVOLUTION_GET_BY_ID_DESCRIPTION + "}")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "#{" + I18nCodes.API_RESPONSE_CREATED + "}", content = @Content(schema = @Schema(implementation = FormEvolutionDto.class))), @ApiResponse(responseCode = "404", description = "#{" + I18nCodes.API_RESPONSE_NOT_FOUND + "}"), @ApiResponse(responseCode = "500", description = "#{" + I18nCodes.API_RESPONSE_INTERNAL_SERVER_ERROR + "}")})
    public ResponseEntity<?> findAll(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "#{" + I18nCodes.API_FORM_EVOLUTION_DELETE_BY_ID_SUMMARY + "}", description = "#{" + I18nCodes.API_FORM_EVOLUTION_DELETE_BY_ID_DESCRIPTION + "}")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "#{" + I18nCodes.API_RESPONSE_CREATED + "}", content = @Content(schema = @Schema(implementation = FormEvolutionDto.class))), @ApiResponse(responseCode = "404", description = "#{" + I18nCodes.API_RESPONSE_NOT_FOUND + "}"), @ApiResponse(responseCode = "500", description = "#{" + I18nCodes.API_RESPONSE_INTERNAL_SERVER_ERROR + "}")})
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return service.deleted(id);
    }


}
