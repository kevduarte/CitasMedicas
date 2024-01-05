package com.citas.demo.repository;
import com.citas.demo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    // Puedes añadir métodos de consulta personalizados aquí si es necesario
}
