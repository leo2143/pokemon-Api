package com.pokemon_api.pokemon_api.controller;

import com.pokemon_api.pokemon_api.dto.create.TypeAttackCreateDto;
import com.pokemon_api.pokemon_api.dto.update.TypeAttackUpdateDto;
import com.pokemon_api.pokemon_api.i18n.I18nCodes;
import com.pokemon_api.pokemon_api.services.TypeAttackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("type-attacks")
@RestController
@AllArgsConstructor
@Tag(name = "types attacks Api", description = "Api orientada a brindar informacion acerca de los tipos de ataque de pokemons")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class TypeAttacksController {

    private final TypeAttackService service;

    @PostMapping("")
    @Operation(summary = "#{" + I18nCodes.API_POKEMON_TYPE_ATTACK_POST_SUMMARY + "}", description = "#{" + I18nCodes.API_POKEMON_TYPE_ATTACK_POST_DESCRIPTION + "}")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "#{" + I18nCodes.API_RESPONSE_CREATED + "}"), @ApiResponse(responseCode = "404", description = "#{" + I18nCodes.API_RESPONSE_NOT_FOUND + "}"), @ApiResponse(responseCode = "500", description = "#{" + I18nCodes.API_RESPONSE_INTERNAL_SERVER_ERROR + "}")})
    public ResponseEntity<?> create(@RequestBody TypeAttackCreateDto create) {
        return this.service.create(create);
    }

    @PutMapping("")
    @Operation(summary = "#{" + I18nCodes.API_POKEMON_TYPE_ATTACK_PUT_SUMMARY + "}", description = "#{" + I18nCodes.API_POKEMON_TYPE_ATTACK_PUT_DESCRIPTION + "}")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "#{" + I18nCodes.API_RESPONSE_CREATED + "}"), @ApiResponse(responseCode = "404", description = "#{" + I18nCodes.API_RESPONSE_NOT_FOUND + "}"), @ApiResponse(responseCode = "500", description = "#{" + I18nCodes.API_RESPONSE_INTERNAL_SERVER_ERROR + "}")})
    public ResponseEntity<?> update(@RequestBody TypeAttackUpdateDto update) {
        return service.update(update, update.getId());
    }


    @GetMapping("")
    @Operation(summary = "#{" + I18nCodes.API_POKEMON_TYPE_ATTACK_GET_ALL_SUMMARY + "}", description = "#{" + I18nCodes.API_POKEMON_TYPE_ATTACK_GET_ALL_DESCRIPTION + "}")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "#{" + I18nCodes.API_RESPONSE_CREATED + "}"), @ApiResponse(responseCode = "404", description = "#{" + I18nCodes.API_RESPONSE_NOT_FOUND + "}"), @ApiResponse(responseCode = "500", description = "#{" + I18nCodes.API_RESPONSE_INTERNAL_SERVER_ERROR + "}")})
    public ResponseEntity<?> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "#{" + I18nCodes.API_POKEMON_TYPE_ATTACK_GET_BY_ID_SUMMARY + "}", description = "#{" + I18nCodes.API_POKEMON_TYPE_ATTACK_GET_BY_ID_DESCRIPTION + "}")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "#{" + I18nCodes.API_RESPONSE_CREATED + "}"), @ApiResponse(responseCode = "404", description = "#{" + I18nCodes.API_RESPONSE_NOT_FOUND + "}"), @ApiResponse(responseCode = "500", description = "#{" + I18nCodes.API_RESPONSE_INTERNAL_SERVER_ERROR + "}")})
    public ResponseEntity<?> findAll(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "#{" + I18nCodes.API_POKEMON_TYPE_ATTACK_DELETE_BY_ID_SUMMARY + "}", description = "#{" + I18nCodes.API_POKEMON_TYPE_ATTACK_DELETE_BY_ID_DESCRIPTION + "}")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "#{" + I18nCodes.API_RESPONSE_CREATED + "}"), @ApiResponse(responseCode = "404", description = "#{" + I18nCodes.API_RESPONSE_NOT_FOUND + "}"), @ApiResponse(responseCode = "500", description = "#{" + I18nCodes.API_RESPONSE_INTERNAL_SERVER_ERROR + "}")})
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return service.deleted(id);
    }


}
