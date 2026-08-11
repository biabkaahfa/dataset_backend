package com.example.dataset.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DatasetDTO {
    private Long id;
    
    @NotBlank(message = "Le nom du dataset est obligatoire")
    private String nom;
    
    private String description;
    
    @NotBlank(message = "La source du dataset est obligatoire")
    private String source;
    
    @NotNull(message = "Le nombre d'observations est obligatoire")
    private Long nombreObservations;
    
    private String format;
    private LocalDateTime dateAjout;
}
