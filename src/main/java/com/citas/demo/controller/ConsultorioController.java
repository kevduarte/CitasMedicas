package com.citas.demo.controller;
import com.citas.demo.entity.Consultorio;
import com.citas.demo.service.ConsultorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultorios")
public class ConsultorioController {

    private final ConsultorioService consultorioService;

    @Autowired
    public ConsultorioController(ConsultorioService consultorioService) {
        this.consultorioService = consultorioService;
    }

    @GetMapping("/listar")
    public List<Consultorio> listarConsultorios() {
        return consultorioService.listarConsultorios();
    }

    @PostMapping("/agregar")
    public ResponseEntity<Consultorio> agregarConsultorio(@RequestBody Consultorio consultorio) {
        Consultorio nuevoConsultorio = consultorioService.agregarConsultorio(consultorio);
        return new ResponseEntity<>(nuevoConsultorio, HttpStatus.CREATED);
    }
}
