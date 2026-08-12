package com.example.dataset.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class ModeleML {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String type;
    private String algorithme;
    private String version;
    private LocalDateTime dateCreation;

    @OneToMany(mappedBy = "modele", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Experimentation> experimentations;

    @PrePersist
    protected void onCreate() {
        this.dateCreation = LocalDateTime.now();
    }
}

