package com.example.dataset.common.controller;

import com.example.dataset.common.mapper.GenericMapper;
import com.example.dataset.common.service.GenericService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Abstract generic controller for common CRUD operations.
 *
 * @param <T> Entity class
 * @param <D> DTO class
 * @param <ID> ID class
 */
public abstract class GenericController<T, D, ID> {

    protected abstract GenericService<T, ID> getService();
    protected abstract GenericMapper<T, D> getMapper();

    @PostMapping
    public ResponseEntity<D> create(@RequestBody D dto) {
        T entity = getMapper().toEntity(dto);
        T savedEntity = getService().save(entity);
        return new ResponseEntity<>(getMapper().toDto(savedEntity), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> getById(@PathVariable ID id) {
        Optional<T> entityOpt = getService().findById(id);
        return entityOpt.map(entity -> ResponseEntity.ok(getMapper().toDto(entity)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<D>> getAll() {
        List<T> entities = getService().findAll();
        return ResponseEntity.ok(getMapper().toDto(entities));
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable ID id, @RequestBody D dto) {
        try {
            T entity = getMapper().toEntity(dto);
            T updatedEntity = getService().update(id, entity);
            return ResponseEntity.ok(getMapper().toDto(updatedEntity));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        getService().deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
