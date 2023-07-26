package cl.usach.preguntasservice.services;

import cl.usach.preguntasservice.entities.PreguntasEntity;
import cl.usach.preguntasservice.repositories.PreguntasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PreguntasService {
    @Autowired
    PreguntasRepository preguntasRepository;
    public List<PreguntasEntity> getAllPreguntas() {
        return preguntasRepository.findAll();
    }

    public boolean idAlreadyExists(Long id) {
        return preguntasRepository.existsById(id);
    }

    public List<PreguntasEntity> getPreguntasByDificultad(String dificultad) {
        List<PreguntasEntity> preguntas = preguntasRepository.findByDificultad(dificultad);
        Collections.shuffle(preguntas);
        if(preguntas.size() < 4)
            return preguntas;
        return preguntas.subList(0, 4);
    }

    public PreguntasEntity guardarPregunta(PreguntasEntity pregunta) {
        pregunta.setId(10000L);
        return preguntasRepository.save(pregunta);
    }
}