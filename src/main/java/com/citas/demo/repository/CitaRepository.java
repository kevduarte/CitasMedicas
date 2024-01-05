package com.citas.demo.repository;
import com.citas.demo.entity.Cita;
import com.citas.demo.entity.Consultorio;
import com.citas.demo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByDoctorAndHorarioConsulta(Doctor doctor, Date horarioConsulta);

    List<Cita> findByConsultorioAndHorarioConsulta(Consultorio consultorio, Date horarioConsulta);

    List<Cita> findByNombrePacienteAndHorarioConsultaBetween(String nombrePaciente, Date inicio, Date fin);

    List<Cita> findByDoctorAndHorarioConsultaBetween(Doctor doctor, Date inicio, Date fin);
}