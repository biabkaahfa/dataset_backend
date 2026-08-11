package com.example.dataset.repository;

import com.example.dataset.common.repository.GenericRepository;
import com.example.dataset.domain.entity.ModeleML;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeleMLRepository extends GenericRepository<ModeleML, Long> {
}
