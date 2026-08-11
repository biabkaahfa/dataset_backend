package com.example.dataset.common.service;

import com.example.dataset.common.repository.GenericRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Abstract implementation of GenericService.
 *
 * @param <T> Entity class
 * @param <ID> ID class
 */
public abstract class GenericServiceImpl<T, ID> implements GenericService<T, ID> {

    protected abstract GenericRepository<T, ID> getRepository();

    @Override
    @Transactional
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    @Transactional
    public T update(ID id, T entity) {
        if (!getRepository().existsById(id)) {
            throw new IllegalArgumentException("Entity with id " + id + " not found");
        }
        return getRepository().save(entity);
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }
}
