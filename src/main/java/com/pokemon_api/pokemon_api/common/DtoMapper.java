package com.pokemon_api.pokemon_api.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface DtoMapper<E, D> extends MapStructMapper {

    D ToDto(E createDto);

    List<D> toListDto(List<E> entityList);

    default PageDto<D> toPageDto(Page<E> entityList) {
        List<D> dtoList = toListDto(entityList.getContent());
        PageDto<D> pageDto = new PageDto<>();
        PageableDto pageableDto = new PageableDto();

        pageDto.setContent(dtoList);
        pageDto.setTotalPages(entityList.getTotalPages());
        pageDto.setTotalElements(dtoList.size());
        Sort sort = entityList.getSort();
        pageDto.setSort(sort);
        pageableDto.setPageNumber(entityList.getPageable().getPageNumber());
        pageableDto.setPageSize(entityList.getPageable().getPageSize());
        pageDto.setPageable(pageableDto);

        return pageDto;

    }


}
