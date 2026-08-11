package com.example.dataset.repository;

import com.example.dataset.common.repository.GenericRepository;
import com.example.dataset.domain.entity.Experimentation;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperimentationRepository extends GenericRepository<Experimentation, Long> {
}
