package com.pokemon_api.pokemon_api.common;

public abstract class DefaultMapper<D, E, C, U> implements DtoMapper<E, D>, CreateMapper<E, C>, UpdateMapper<E, U>,MapStructMapper {


}
