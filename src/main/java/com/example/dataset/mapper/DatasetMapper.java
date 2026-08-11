package com.example.dataset.mapper;

import com.example.dataset.common.mapper.GenericMapper;
import com.example.dataset.domain.dto.DatasetDTO;
import com.example.dataset.domain.entity.Dataset;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DatasetMapper extends GenericMapper<Dataset, DatasetDTO> {
}
