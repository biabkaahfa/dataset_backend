package com.example.dataset.controller;

import com.example.dataset.common.controller.GenericController;
import com.example.dataset.common.mapper.GenericMapper;
import com.example.dataset.common.service.GenericService;
import com.example.dataset.domain.dto.ModeleMLDTO;
import com.example.dataset.domain.entity.ModeleML;
import com.example.dataset.mapper.ModeleMLMapper;
import com.example.dataset.service.ModeleMLService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/modeles")
@RequiredArgsConstructor
@Tag(name = "Modèles ML", description = "API pour gérer les modèles de Machine Learning")
public class ModeleMLController extends GenericController<ModeleML, ModeleMLDTO, Long> {

    private final ModeleMLService service;
    private final ModeleMLMapper mapper;

    @Override
    protected GenericService<ModeleML, Long> getService() {
        return service;
    }

    @Override
    protected GenericMapper<ModeleML, ModeleMLDTO> getMapper() {
        return mapper;
    }
}
