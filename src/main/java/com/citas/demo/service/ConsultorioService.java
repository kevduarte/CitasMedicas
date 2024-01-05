package com.citas.demo.service;
import com.citas.demo.entity.Consultorio;
import com.citas.demo.repository.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultorioService {

    private final ConsultorioRepository consultorioRepository;

    @Autowired
    public ConsultorioService(ConsultorioRepository consultorioRepository) {
        this.consultorioRepository = consultorioRepository;
    }

    public List<Consultorio> listarConsultorios() {
        return consultorioRepository.findAll();
    }

    public Consultorio agregarConsultorio(Consultorio consultorio) {
        return consultorioRepository.save(consultorio);
    }
}
