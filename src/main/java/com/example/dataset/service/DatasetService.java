package com.example.dataset.service;

import com.example.dataset.common.repository.GenericRepository;
import com.example.dataset.common.service.GenericService;
import com.example.dataset.domain.entity.Dataset;
import com.example.dataset.repository.DatasetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DatasetService extends GenericService<Dataset, Long> {

    private final DatasetRepository repository;

    @Override
    protected GenericRepository<Dataset, Long> getRepository() {
        return repository;
    }
}
