package com.pokemon_api.pokemon_api.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class PageDto<D> {

    private int totalPages;

    private int totalElements;

    private int numberOfElements;

    private Sort sort;

    private PageableDto pageable;

    private List<D> content;

}
