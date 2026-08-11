package com.example.dataset.repository;

import com.example.dataset.common.repository.GenericRepository;
import com.example.dataset.domain.entity.Dataset;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasetRepository extends GenericRepository<Dataset, Long> {
}
