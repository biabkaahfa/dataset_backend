package com.example.dataset.service;

import com.example.dataset.common.repository.GenericRepository;
import com.example.dataset.common.service.GenericService;
import com.example.dataset.domain.entity.Experimentation;
import com.example.dataset.repository.ExperimentationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExperimentationService extends GenericService<Experimentation, Long> {

    private final ExperimentationRepository repository;

    @Override
    protected GenericRepository<Experimentation, Long> getRepository() {
        return repository;
    }
}
