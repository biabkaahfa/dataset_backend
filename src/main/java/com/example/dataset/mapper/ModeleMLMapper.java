package com.example.dataset.mapper;

import com.example.dataset.common.mapper.GenericMapper;
import com.example.dataset.domain.dto.ModeleMLDTO;
import com.example.dataset.domain.entity.ModeleML;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModeleMLMapper extends GenericMapper<ModeleML, ModeleMLDTO> {
}
