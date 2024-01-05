package com.citas.demo.controller;
import com.citas.demo.entity.Cita;
import com.citas.demo.service.CitaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private final CitaService citaService;

    @Autowired
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping("/listar")
    public List<Cita> listarCitas() {
        return citaService.listarCitas();
    }

    @PostMapping("/agregar")
    public ResponseEntity<Cita> altaCita(@Valid @RequestBody Cita cita) {
        Cita nuevaCita = citaService.altaCita(cita);
        return new ResponseEntity<>(nuevaCita, HttpStatus.CREATED);
    }

}
