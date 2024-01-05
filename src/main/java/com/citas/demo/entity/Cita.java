package com.citas.demo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;


import java.util.Date;

@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "El consultorio es requerido")
    private Consultorio consultorio;

    @ManyToOne
    @NotNull(message = "El doctor es requerido")
    private Doctor doctor;

    @NotNull(message = "El horario de consulta es requerido")
    private Date horarioConsulta;

    @NotBlank(message = "El nombre del paciente es requerido")
    private String nombrePaciente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(Date horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
}
