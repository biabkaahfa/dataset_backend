package com.example.dataset.common.controller;

import com.example.dataset.common.mapper.GenericMapper;
import com.example.dataset.common.service.GenericService;
import com.example.dataset.common.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

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
    public ResponseEntity<ApiResponse<D>> create(@Valid @RequestBody D dto) {
        T entity = getMapper().toEntity(dto);
        T savedEntity = getService().save(entity);
        D savedDto = getMapper().toDto(savedEntity);
        return new ResponseEntity<>(ApiResponse.created(savedDto, "Création réussie"), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<D>> getById(@PathVariable ID id) {
        Optional<T> entityOpt = getService().findById(id);
        return entityOpt.map(entity -> ResponseEntity.ok(ApiResponse.success(getMapper().toDto(entity), "Récupération réussie")))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error(404, "Entité non trouvée")));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<D>>> getAll() {
        List<T> entities = getService().findAll();
        return ResponseEntity.ok(ApiResponse.success(getMapper().toDto(entities), "Récupération de la liste réussie"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<D>> update(@PathVariable ID id, @Valid @RequestBody D dto) {
        try {
            T entity = getMapper().toEntity(dto);
            T updatedEntity = getService().update(id, entity);
            D updatedDto = getMapper().toDto(updatedEntity);
            return ResponseEntity.ok(ApiResponse.success(updatedDto, "Mise à jour réussie"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(404, "Entité non trouvée pour la mise à jour"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable ID id) {
        getService().deleteById(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Suppression réussie"));
    }
}
