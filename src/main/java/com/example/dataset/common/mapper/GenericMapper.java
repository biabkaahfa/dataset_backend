package com.example.dataset.common.mapper;

import java.util.List;

/**
 * Generic mapper interface for MapStruct.
 *
 * @param <E> Entity class
 * @param <D> DTO class
 */
public interface GenericMapper<E, D> {
    
    D toDto(E entity);

    E toEntity(D dto);

    List<D> toDto(List<E> entityList);

    List<E> toEntity(List<D> dtoList);
}
