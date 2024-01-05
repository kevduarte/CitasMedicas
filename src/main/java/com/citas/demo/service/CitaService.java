package com.citas.demo.service;
import com.citas.demo.entity.Cita;
import com.citas.demo.repository.CitaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CitaService {

    private final CitaRepository citaRepository;

    @Autowired
    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    @Transactional
    public Cita altaCita(Cita cita) {
        validarCitaParaMismoDoctorYHora(cita);
        validarCitaParaMismoConsultorioYHora(cita);
        validarCitaParaMismoPacienteYHora(cita);
        validarLimiteCitasDiariasParaDoctor(cita);

        return citaRepository.save(cita);
    }

    private void validarCitaParaMismoDoctorYHora(Cita nuevaCita) {
        List<Cita> citasParaMismoDoctorYHora = citaRepository.findByDoctorAndHorarioConsulta(
                nuevaCita.getDoctor(),
                nuevaCita.getHorarioConsulta()
        );
        if (!citasParaMismoDoctorYHora.isEmpty()) {
            throw new IllegalStateException("Ya hay una cita agendada para el mismo doctor y hora");
        }
    }

    private void validarCitaParaMismoConsultorioYHora(Cita nuevaCita) {
        List<Cita> citasParaMismoConsultorioYHora = citaRepository.findByConsultorioAndHorarioConsulta(
                nuevaCita.getConsultorio(),
                nuevaCita.getHorarioConsulta()
        );
        if (!citasParaMismoConsultorioYHora.isEmpty()) {
            throw new IllegalStateException("Ya hay una cita agendada para el mismo consultorio y hora");
        }
    }

    private void validarCitaParaMismoPacienteYHora(Cita nuevaCita) {
        List<Cita> citasParaMismoPacienteYHora = citaRepository.findByNombrePacienteAndHorarioConsultaBetween(
                nuevaCita.getNombrePaciente(),
                new Date(nuevaCita.getHorarioConsulta().getTime() - 2 * 60 * 60 * 1000),  // 2 horas antes
                new Date(nuevaCita.getHorarioConsulta().getTime() + 2 * 60 * 60 * 1000)   // 2 horas después
        );
        if (!citasParaMismoPacienteYHora.isEmpty()) {
            throw new IllegalStateException("Ya hay una cita agendada para el mismo paciente en una franja de 2 horas");
        }
    }

    private void validarLimiteCitasDiariasParaDoctor(Cita nuevaCita) {
        Date inicioDia = truncarHora(nuevaCita.getHorarioConsulta());
        Date finDia = new Date(inicioDia.getTime() + 24 * 60 * 60 * 1000);  // 24 horas después

        List<Cita> citasDelDiaParaDoctor = citaRepository.findByDoctorAndHorarioConsultaBetween(
                nuevaCita.getDoctor(),
                inicioDia,
                finDia
        );

        if (citasDelDiaParaDoctor.size() >= 8) {
            throw new IllegalStateException("El doctor ya tiene el máximo de citas permitidas para el día");
        }
    }

    private Date truncarHora(Date date) {
        long millisInDay = 24 * 60 * 60 * 1000;
        return new Date(date.getTime() / millisInDay * millisInDay);
    }
}
