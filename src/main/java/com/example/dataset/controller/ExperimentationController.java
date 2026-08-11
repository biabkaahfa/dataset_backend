package com.example.dataset.controller;

import com.example.dataset.common.controller.GenericController;
import com.example.dataset.common.mapper.GenericMapper;
import com.example.dataset.common.service.GenericService;
import com.example.dataset.domain.dto.ExperimentationDTO;
import com.example.dataset.domain.entity.Experimentation;
import com.example.dataset.mapper.ExperimentationMapper;
import com.example.dataset.service.ExperimentationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/experimentations")
@RequiredArgsConstructor
@Tag(name = "Expérimentations", description = "API pour gérer les expérimentations (association Modèle / Dataset)")
public class ExperimentationController extends GenericController<Experimentation, ExperimentationDTO, Long> {

    private final ExperimentationService service;
    private final ExperimentationMapper mapper;

    @Override
    protected GenericService<Experimentation, Long> getService() {
        return service;
    }

    @Override
    protected GenericMapper<Experimentation, ExperimentationDTO> getMapper() {
        return mapper;
    }
}
