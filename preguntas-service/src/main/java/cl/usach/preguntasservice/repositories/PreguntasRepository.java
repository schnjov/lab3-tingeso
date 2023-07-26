package cl.usach.preguntasservice.repositories;

import cl.usach.preguntasservice.entities.PreguntasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreguntasRepository extends JpaRepository<PreguntasEntity, Long> {
    List<PreguntasEntity> findByDificultad(String dificultad);
}
