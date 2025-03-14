package com.pokemon_api.pokemon_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Modelo de respuesta para movimientos secundarios")
public class FormEvolutionDto {

    @Schema(description = "id movimientos secundarios")
    private Long id;

    private TypeEvolutionDto typeEvolution;



}
