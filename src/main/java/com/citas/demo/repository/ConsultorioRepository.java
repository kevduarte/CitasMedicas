package com.citas.demo.repository;
import com.citas.demo.entity.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultorioRepository extends JpaRepository<Consultorio, Integer> {

    // Puedes añadir métodos de consulta personalizados aquí si es necesario
}
