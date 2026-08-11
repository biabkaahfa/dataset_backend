package com.example.dataset.mapper;

import com.example.dataset.common.mapper.GenericMapper;
import com.example.dataset.domain.dto.ExperimentationDTO;
import com.example.dataset.domain.entity.Experimentation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExperimentationMapper extends GenericMapper<Experimentation, ExperimentationDTO> {
    
    @Override
    @Mapping(source = "dataset.id", target = "datasetId")
    @Mapping(source = "modele.id", target = "modeleId")
    ExperimentationDTO toDto(Experimentation entity);
    
    @Override
    @Mapping(source = "datasetId", target = "dataset.id")
    @Mapping(source = "modeleId", target = "modele.id")
    Experimentation toEntity(ExperimentationDTO dto);
}
