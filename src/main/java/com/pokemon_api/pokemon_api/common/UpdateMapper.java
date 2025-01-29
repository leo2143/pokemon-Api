package com.pokemon_api.pokemon_api.common;

import java.util.List;

public interface UpdateMapper<E,U> extends MapStructMapper{


    E merge(E entity, U update);



}
