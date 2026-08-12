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
public class Dataset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private String source;
    private Long nombreObservations;
    private String format;
    private LocalDateTime dateAjout;

    @OneToMany(mappedBy = "dataset", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Experimentation> experimentations;

    @PrePersist
    protected void onCreate() {
        this.dateAjout = LocalDateTime.now();
    }
}
