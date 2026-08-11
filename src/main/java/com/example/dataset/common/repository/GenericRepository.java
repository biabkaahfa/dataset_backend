package com.example.dataset.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Generic repository interface extending JpaRepository.
 *
 * @param <T> Entity class
 * @param <ID> ID class
 */
@NoRepositoryBean
public interface GenericRepository<T, ID> extends JpaRepository<T, ID> {
}
