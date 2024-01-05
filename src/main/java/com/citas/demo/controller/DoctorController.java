package com.citas.demo.controller;
import com.citas.demo.entity.Doctor;
import com.citas.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctores")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/listar")
    public List<Doctor> listarDoctores() {
        return doctorService.listarDoctores();
    }

    @PostMapping("/agregar")
    public ResponseEntity<Doctor> agregarDoctor(@RequestBody Doctor doctor) {
        Doctor nuevoDoctor = doctorService.agregarDoctor(doctor);
        return new ResponseEntity<>(nuevoDoctor, HttpStatus.CREATED);
    }
}
