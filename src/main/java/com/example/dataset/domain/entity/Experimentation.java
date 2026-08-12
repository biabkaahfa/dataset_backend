package com.example.dataset.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Experimentation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dataset_id")
    private Dataset dataset;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modele_ml_id")
    private ModeleML modele;

    private Double accuracy;
    private Double f1Score;
    private Long dureeEntrainement;
    private LocalDateTime dateExecution;

    @PrePersist
    protected void onCreate() {
        this.dateExecution = LocalDateTime.now();
    }
}

