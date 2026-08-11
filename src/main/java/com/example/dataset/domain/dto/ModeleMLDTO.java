package com.example.dataset.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ModeleMLDTO {
    private Long id;
    
    @NotBlank(message = "Le nom du modèle est obligatoire")
    private String nom;
    
    @NotBlank(message = "Le type de modèle est obligatoire")
    private String type;
    
    @NotBlank(message = "L'algorithme est obligatoire")
    private String algorithme;
    
    private String version;
    private LocalDateTime dateCreation;
}
