package com.Citas.demo.Citas.repository;

import com.Citas.demo.Citas.modelo.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamientoCitasRepo extends JpaRepository<Cita, Long> {
}
