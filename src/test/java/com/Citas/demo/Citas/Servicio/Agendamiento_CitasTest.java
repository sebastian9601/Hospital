package com.Citas.demo.Citas.Servicio;

import com.Citas.demo.Citas.modelo.Cita;
import com.Citas.demo.Citas.repository.AgendamientoCitasRepo;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

    class Agendamiento_CitasTest {

        @Mock
        private AgendamientoCitasRepo agendamientoCitasRepo;
        private Agendamiento_Citas agendamiento_citas;

        @Test()
        public void testCrearCitaParaUsuarioEPS() {


            Cita cita = new Cita();
            cita.setTipoUsuario("EPS");

            Cita citaCreada = agendamiento_citas.crearCita(cita);

            LocalDate fechaEsperada = LocalDate.now();
            int dias = 10;
            while (dias > 0) {
                fechaEsperada = fechaEsperada.plusDays(1);
                if (fechaEsperada.getDayOfWeek().getValue() < 6) {
                    dias--;
                }
            }

            assertEquals(fechaEsperada, citaCreada.getFechaCita());
        }
        @Test
        public void testCrearCitaParaUsuarioPoliza() {
            Cita cita = new Cita();
            cita.setTipoUsuario("POLIZA");

            Cita citaCreada = agendamiento_citas.crearCita(cita);

            LocalDate fechaEsperada = LocalDate.now().plusDays(8);

            assertEquals(fechaEsperada, citaCreada.getFechaCita());
        }

        @Test
        public void testCrearCitaParaUsuarioParticular() {
            Cita cita = new Cita();
            cita.setTipoUsuario("PARTICULAR");

            Cita citaCreada = agendamiento_citas.crearCita(cita);

            LocalDate fechaActual = LocalDate.now();
            int dias = 7;
            while (dias > 0) {
                fechaActual = fechaActual.plusDays(1);
                if (fechaActual.getDayOfWeek().getValue() < 6) {
                    dias--;
                }
            }

            assertEquals(fechaActual, citaCreada.getFechaCita());
        }

        @Test
        public void testCrearCitaParaUsuarioInvalido() {
            Cita cita = new Cita();
            cita.setTipoUsuario("INVALIDO");

            agendamiento_citas.crearCita(cita);
        }
}



