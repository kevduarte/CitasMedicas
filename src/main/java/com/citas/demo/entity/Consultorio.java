package com.citas.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Consultorio {

    @Id
    private int numeroConsultorio;
    private int piso;


    public int getNumeroConsultorio() {
        return numeroConsultorio;
    }

    public void setNumeroConsultorio(int numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
}
