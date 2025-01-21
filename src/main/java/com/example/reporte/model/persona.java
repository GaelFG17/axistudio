package com.example.reporte.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class persona {

    @Id
    @Column(name = "clv_persona", nullable = false, length = 15)
    private String clvPersona;

    @Column(name = "nombre_persona", nullable = false, length = 20)
    private String nombrePersona;

    @Column(name = "apellido_paterno", nullable = false, length = 50)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = false, length = 50)
    private String apellidoMaterno;

    @Column(name = "CURP", nullable = false, length = 18)
    private String curp;

    @Column(name = "RFC", nullable = false, length = 13)
    private String rfc;

    @Column(name = "correo_electronico", nullable = false, length = 20)
    private String correoElectronico;
}
