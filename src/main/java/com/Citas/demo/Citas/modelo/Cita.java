package com.Citas.demo.Citas.modelo;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

    @Table(name = "citas")
    @Entity
    public class Cita implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(length = 10)
        private Long idUsuario;
        @Column(length = 10)
        private String especialidad;
        private LocalDate fechaCita;
        @Column(nullable = false)
        private String tipoUsuario;

        public Cita() {
        }

        public Cita(Dto dto) {
            this.idUsuario = dto.getIdUsuario();
            this.especialidad = dto.getEspecialidad();
            this.fechaCita = dto.getFechaCita();
            this.tipoUsuario = dto.getTipoUsuario();

        }

        public Cita(String especialidad, Long idUsuario, String tipoUsuario, LocalDate fechaCita) {
            this.especialidad = especialidad;
            this.idUsuario = idUsuario;
            this.tipoUsuario = tipoUsuario;
            this.fechaCita = fechaCita;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getEspecialidad() {
            return especialidad;
        }

        public void setEspecialidad(String especialidad) {
            this.especialidad = especialidad;
        }

        public Long getIdentificacionUsuario() {
            return idUsuario;
        }

        public void setIdentificacionUsuario(Long identificacionUsuario) {
            this.idUsuario = identificacionUsuario;
        }

        public String getTipoUsuario() {
            return tipoUsuario;
        }

        public void setTipoUsuario(String tipoUsuario) {
            this.tipoUsuario = tipoUsuario;
        }

        public Long getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(Long idUsuario) {
            this.idUsuario = idUsuario;
        }

        public LocalDate getFechaCita() {
            return fechaCita;
        }

        public void setFechaCita(LocalDate fechaCita) {
            this.fechaCita = fechaCita;
        }

        @Override
        public String toString() {
        return "Cita{" +
                "  idUsuario=" + idUsuario +
                ", especialidad='" + especialidad + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}
