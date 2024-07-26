package com.pokemon_api.pokemon_api.services;

import com.pokemon_api.pokemon_api.dto.CustomResponse;
import com.pokemon_api.pokemon_api.dto.PokemonDto;
import com.pokemon_api.pokemon_api.model.PokemonEntity;
import com.pokemon_api.pokemon_api.repository.PokemonRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


//FIX:Buscar la forma de pasar a forma generica la crecion update y demas servicios para el posterior uso abstracto
@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class PokemonService {

    @Autowired
    private PokemonRepository repository;

    public ResponseEntity<?> create(PokemonDto createDto) {

        PokemonEntity pokemon = new PokemonEntity();
        pokemon.setName(createDto.getName());
        pokemon.setHeight(createDto.getHeight());
        pokemon.setWeight(createDto.getWeight());
        repository.save(pokemon);

        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }

    public ResponseEntity<?> update(PokemonDto updateDto) {

        PokemonEntity pokemon = repository.findById(updateDto.getId()).orElse(null);
        if (pokemon != null) {
            pokemon.setName(updateDto.getName());
            pokemon.setHeight(updateDto.getHeight());
            pokemon.setWeight(updateDto.getWeight());
            repository.save(pokemon);
            return ResponseEntity.ok(pokemon);
        }
        return new ResponseEntity<>("hubo un error al crear el pokemon", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> findById(Long id) {

        PokemonEntity pokemon = repository.findById(id).orElse(null);
        if (pokemon != null) {
            return new ResponseEntity<>(pokemon, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("no se encontro el pokemon con el id", HttpStatus.OK);

        }

    }

    public ResponseEntity<?> findAll() {
    //pensar la forma en la que sea mas dinamica de pasar el codigo, asi no tener que hacer caso por caso y se mas generico
        List<PokemonEntity> pokemon = repository.findAll();
        if (pokemon.size() > 0 && pokemon != null) {
            CustomResponse customResponse = new CustomResponse(HttpStatus.OK.value(),"se a creado correctamente",pokemon);
            return new ResponseEntity<>(customResponse,HttpStatus.OK);
        } else {
            return new ResponseEntity<>("no se encontro ningun pokemon", HttpStatus.OK);

        }


    }

    public ResponseEntity<?> deleted(Long id) {

        if (id != null) {

            PokemonEntity pokemon = repository.findById(id).orElse(null);

            if (pokemon != null) {
                repository.delete(pokemon);
                return new ResponseEntity<>(pokemon, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("no se encontro el pokemon con el id: " + id, HttpStatus.NOT_FOUND);

            }


        }
        return new ResponseEntity<>("debes enviar el id del pokemon", HttpStatus.BAD_REQUEST);
    }
}
