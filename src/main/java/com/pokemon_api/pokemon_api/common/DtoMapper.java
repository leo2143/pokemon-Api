package com.pokemon_api.pokemon_api.common;

import java.util.List;

public interface DtoMapper<E,D> extends MapStructMapper{

    D ToDto(E createDto);

    List<D> toListDto(List<E> entityList);


}
