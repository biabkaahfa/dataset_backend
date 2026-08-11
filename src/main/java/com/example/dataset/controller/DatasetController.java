package com.example.dataset.controller;

import com.example.dataset.common.controller.GenericController;
import com.example.dataset.common.mapper.GenericMapper;
import com.example.dataset.common.service.GenericService;
import com.example.dataset.domain.dto.DatasetDTO;
import com.example.dataset.domain.entity.Dataset;
import com.example.dataset.mapper.DatasetMapper;
import com.example.dataset.service.DatasetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/datasets")
@RequiredArgsConstructor
@Tag(name = "Datasets", description = "API pour gérer les datasets")
public class DatasetController extends GenericController<Dataset, DatasetDTO, Long> {

    private final DatasetService service;
    private final DatasetMapper mapper;

    @Override
    protected GenericService<Dataset, Long> getService() {
        return service;
    }

    @Override
    protected GenericMapper<Dataset, DatasetDTO> getMapper() {
        return mapper;
    }
}
