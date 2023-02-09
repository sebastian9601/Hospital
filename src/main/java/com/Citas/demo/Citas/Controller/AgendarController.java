package com.Citas.demo.Citas.Controller;

import com.Citas.demo.Citas.Servicio.Agendamiento_Citas;
import com.Citas.demo.Citas.modelo.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/v1/agendar")
    @CrossOrigin(origins = "*")
    public class AgendarController {

        @Autowired
        private Agendamiento_Citas agendamiento_citas;

        @PostMapping
        public ResponseEntity <Cita> agendarCita (@RequestBody Cita cita) {
            return new ResponseEntity<>(agendamiento_citas.crearCita(cita), HttpStatus.CREATED);

        }

        @GetMapping("/{id}")
        public ResponseEntity<Cita> buscarId (@PathVariable("id") Long idUsuario) {
        Cita userById = agendamiento_citas.buscarId(idUsuario);
        if (userById != null) {
            return new ResponseEntity<>(userById, HttpStatus.OK);
        }
        return new ResponseEntity("That user id does not exist!", HttpStatus.INTERNAL_SERVER_ERROR);
    }


}






















