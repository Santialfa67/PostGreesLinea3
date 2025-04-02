package com.example.BaseDatosPostgress.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Recreo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long codigo;

    private String horario;

    @OneToMany(mappedBy = "recreo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estudiante> estudiantes;

    public Recreo(String horario) {
        this.horario = horario;
    }
}
