package com.pokemon_api.pokemon_api.controller;

import com.pokemon_api.pokemon_api.dto.PokemonDto;
import com.pokemon_api.pokemon_api.i18n.I18nCodes;
import com.pokemon_api.pokemon_api.services.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("pokemon")
@RestController
@Tag(name = "pokemons Api", description = "Api orientada a brindar informacion acerca de los pokemons")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class pokemonController {

    @Autowired
    private PokemonService service;

    @PostMapping("")
    @Operation(summary = "#{" + I18nCodes.API_ACCOUNTING_CLEARING_REPORT_POST_SUMMARY + "}", description = "#{" + I18nCodes.API_ACCOUNTING_CLEARING_REPORT_POST_DESCRIPTION + "}")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "#{" + I18nCodes.API_RESPONSE_CREATED + "}"), @ApiResponse(responseCode = "404", description = "#{" + I18nCodes.API_RESPONSE_NOT_FOUND + "}"), @ApiResponse(responseCode = "500", description = "#{" + I18nCodes.API_RESPONSE_INTERNAL_SERVER_ERROR + "}")})
    public ResponseEntity<?> create(@RequestBody PokemonDto create) {
        return this.service.create(create);
    }

    @PutMapping("")
    @Operation(summary = "#{" + I18nCodes.API_ACCOUNTING_CLEARING_REPORT_PUT_SUMMARY + "}", description = "#{" + I18nCodes.API_ACCOUNTING_CLEARING_REPORT_PUT_DESCRIPTION + "}")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "#{" + I18nCodes.API_RESPONSE_CREATED + "}"), @ApiResponse(responseCode = "404", description = "#{" + I18nCodes.API_RESPONSE_NOT_FOUND + "}"), @ApiResponse(responseCode = "500", description = "#{" + I18nCodes.API_RESPONSE_INTERNAL_SERVER_ERROR + "}")})
    public ResponseEntity<?> update(@RequestBody PokemonDto update) {
        return service.update(update);
    }


    @GetMapping("")
    @Operation(summary = "#{" + I18nCodes.API_ACCOUNTING_CLEARING_REPORT_GET_ALL_SUMMARY + "}", description = "#{" + I18nCodes.API_ACCOUNTING_CLEARING_REPORT_GET_ALL_DESCRIPTION + "}")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "#{" + I18nCodes.API_RESPONSE_CREATED + "}"), @ApiResponse(responseCode = "404", description = "#{" + I18nCodes.API_RESPONSE_NOT_FOUND + "}"), @ApiResponse(responseCode = "500", description = "#{" + I18nCodes.API_RESPONSE_INTERNAL_SERVER_ERROR + "}")})
    public ResponseEntity<?> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "#{" + I18nCodes.API_ACCOUNTING_CLEARING_REPORT_GET_BY_ID_SUMMARY + "}", description = "#{" + I18nCodes.API_ACCOUNTING_CLEARING_REPORT_GET_BY_ID_DESCRIPTION + "}")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "#{" + I18nCodes.API_RESPONSE_CREATED + "}"), @ApiResponse(responseCode = "404", description = "#{" + I18nCodes.API_RESPONSE_NOT_FOUND + "}"), @ApiResponse(responseCode = "500", description = "#{" + I18nCodes.API_RESPONSE_INTERNAL_SERVER_ERROR + "}")})
    public ResponseEntity<?> findAll(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "#{" + I18nCodes.API_ACCOUNTING_CLEARING_REPORT_DELETE_BY_ID_SUMMARY + "}", description = "#{" + I18nCodes.API_ACCOUNTING_CLEARING_REPORT_DELETE_BY_ID_DESCRIPTION + "}")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "#{" + I18nCodes.API_RESPONSE_CREATED + "}"), @ApiResponse(responseCode = "404", description = "#{" + I18nCodes.API_RESPONSE_NOT_FOUND + "}"), @ApiResponse(responseCode = "500", description = "#{" + I18nCodes.API_RESPONSE_INTERNAL_SERVER_ERROR + "}")})
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return service.deleted(id);
    }


}
