package com.example.registro.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nombres obligatorios")
    private String nombres;

    @NotBlank(message = "apellidos obligatorios")
    private String apellidos;

    @NotBlank(message = "cedula obligatoria")
    @Column(unique = true)
    private String cedula;

    @NotNull(message = "fecha obligatoria")
    private LocalDate fecha_nacimiento;
}