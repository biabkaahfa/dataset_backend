package com.example.dataset.domain.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExperimentationDTO {
    private Long id;
    
    @NotNull(message = "L'ID du dataset est obligatoire")
    private Long datasetId;
    
    @NotNull(message = "L'ID du modèle est obligatoire")
    private Long modeleId;
    
    @DecimalMin(value = "0.0", message = "L'accuracy doit être au minimum 0.0")
    @DecimalMax(value = "1.0", message = "L'accuracy doit être au maximum 1.0")
    private Double accuracy;
    
    @DecimalMin(value = "0.0", message = "Le F1-Score doit être au minimum 0.0")
    @DecimalMax(value = "1.0", message = "Le F1-Score doit être au maximum 1.0")
    private Double f1Score;
    
    private Long dureeEntrainement;
    private LocalDateTime dateExecution;
}
