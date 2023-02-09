package com.Citas.demo.Citas.modelo;

import jakarta.persistence.Column;

import java.time.LocalDate;

    public class Dto {

    private Long idUsuario;

    private String especialidad;

    private LocalDate fechaCita;

    private String tipoUsuario;

    public Dto() {
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

        @Override
        public String toString() {
            return "Dto{" +
                    "idUsuario=" + idUsuario +
                    ", especialidad='" + especialidad + '\'' +
                    ", fechaCita=" + fechaCita +
                    ", tipoUsuario='" + tipoUsuario + '\'' +
                    '}';
        }
    }
