package com.pokemon_api.pokemon_api.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CustomResponse<E> {

    private int statusCode;

    private String message;

    private E data;

}
