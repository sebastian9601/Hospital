package com.Citas.demo.Citas.Servicio;

import com.Citas.demo.Citas.modelo.Cita;
import com.Citas.demo.Citas.repository.AgendamientoCitasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class Agendamiento_Citas implements CitasServicio {

    @Autowired
    private final AgendamientoCitasRepo agendamientoCitasRepo;

    public Agendamiento_Citas(AgendamientoCitasRepo agendamientoCitasRepo) {
        this.agendamientoCitasRepo = agendamientoCitasRepo;
    }


    @Override
    public Cita buscarId(Long idUsuario) {
        Optional<Cita> buscarId = agendamientoCitasRepo.findById(idUsuario);
        if (buscarId.isPresent()) {
            return buscarId.get();
        }
        return null;
    }

    @Override
    public Cita crearCita(Cita cita) {
        java.time.LocalDate fechaActual = LocalDate.now();
        int dias = 0;
        if (cita.getTipoUsuario().equals("EPS")) {
            dias = 10;
            while (dias > 0) {
                fechaActual = fechaActual.plusDays(1);
                if (fechaActual.getDayOfWeek().getValue() < 6) {
                    dias--;
                }
            }
            cita.setFechaCita(fechaActual);

            return agendamientoCitasRepo.save(cita);

        } else if (cita.getTipoUsuario().equals("POLIZA")) {
        dias = 8;
            fechaActual = fechaActual.plusDays(dias);
            cita.setFechaCita(fechaActual);
            return agendamientoCitasRepo.save(cita);
        } else if (cita.getTipoUsuario().equals("PARTICULAR")) {
        dias = 7;
        while (dias > 0) {
            fechaActual = fechaActual.plusDays(1);
            if (fechaActual.getDayOfWeek().getValue() < 6) {
                dias--;
            }
        }
            cita.setFechaCita(fechaActual);
            return agendamientoCitasRepo.save(cita);
        } else {
        throw new IllegalArgumentException("Tipo de usuario no permitido en el hospital");
        }

        }

}
