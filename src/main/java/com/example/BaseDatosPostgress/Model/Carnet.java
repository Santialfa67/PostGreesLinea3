package com.example.BaseDatosPostgress.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Carnet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String numeroCarnet;
    private String fechaExpedicion;

    @OneToOne(mappedBy = "carnetEstudiantil")
    private Estudiante estudiante;

    public Carnet(String numeroCarnet, String fechaExpedicion, Estudiante estudiante) {
        this.numeroCarnet = numeroCarnet;
        this.fechaExpedicion = fechaExpedicion;
        this.estudiante = estudiante;
    }
}
