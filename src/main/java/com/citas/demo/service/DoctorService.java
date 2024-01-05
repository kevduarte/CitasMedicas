package com.citas.demo.service;

import com.citas.demo.entity.Doctor;
import com.citas.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> listarDoctores() {
        return doctorRepository.findAll();
    }

    public Doctor agregarDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
