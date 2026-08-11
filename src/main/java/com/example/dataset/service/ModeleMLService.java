package com.example.dataset.service;

import com.example.dataset.common.repository.GenericRepository;
import com.example.dataset.common.service.GenericService;
import com.example.dataset.domain.entity.ModeleML;
import com.example.dataset.repository.ModeleMLRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModeleMLService extends GenericService<ModeleML, Long> {

    private final ModeleMLRepository repository;

    @Override
    protected GenericRepository<ModeleML, Long> getRepository() {
        return repository;
    }
}
