package com.pokemon_api.pokemon_api.common;

import java.util.List;

public interface CreateMapper<E,C> extends MapStructMapper{

    E fromCreateDtoToEntity(C createDto);

}
