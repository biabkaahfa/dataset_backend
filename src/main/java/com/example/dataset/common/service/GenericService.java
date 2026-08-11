package com.example.dataset.common.service;

import java.util.List;
import java.util.Optional;

/**
 * Generic service interface.
 *
 * @param <T> Entity class
 * @param <ID> ID class
 */
public interface GenericService<T, ID> {

    T save(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();

    T update(ID id, T entity);

    void deleteById(ID id);
}
