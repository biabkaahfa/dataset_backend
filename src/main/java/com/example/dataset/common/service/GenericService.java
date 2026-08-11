package com.example.dataset.common.service;

import com.example.dataset.common.repository.GenericRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Abstract GenericService class.
 *
 * @param <T> Entity class
 * @param <ID> ID class
 */
public abstract class GenericService<T, ID> {

    protected abstract GenericRepository<T, ID> getRepository();

    @Transactional
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Transactional(readOnly = true)
    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    @Transactional(readOnly = true)
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Transactional
    public T update(ID id, T entity) {
        if (!getRepository().existsById(id)) {
            throw new IllegalArgumentException("Entity with id " + id + " not found");
        }
        return getRepository().save(entity);
    }

    @Transactional
    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }
}
