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

public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long codigo;

    private String nombre;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "recreo_id", nullable = false)
    private Recreo recreo;


    @ManyToMany
    @JoinTable(
            name = "estudiante_profesor",  // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name = "profesor_id")
    )
    private Set<Profesor> profesores = new HashSet<>(); //almacenar elementos de manera única y sin un orden específico

    @OneToOne(cascade = CascadeType.ALL)  // Relación con Carnet
    @JoinColumn(name = "carnet_id", unique = true) // Clave foránea
    private Carnet carnetEstudiantil;

    public Estudiante(String nombre, String telefono, Recreo recreo, Set<Profesor> profesores, Carnet carnetEstudiantil) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.recreo = recreo;
        this.profesores = profesores;
        this.carnetEstudiantil = carnetEstudiantil;
    }
}
