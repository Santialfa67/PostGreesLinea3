package com.example.BaseDatosPostgress.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    private String nombre;
    private String materia;

    @ManyToMany(mappedBy = "profesores")
    private Set<Estudiante> estudiantes = new HashSet<>();

    public Profesor(String nombre, String materia, Set<Estudiante> estudiantes) {
        this.nombre = nombre;
        this.materia = materia;
        this.estudiantes = estudiantes;
    }
}


