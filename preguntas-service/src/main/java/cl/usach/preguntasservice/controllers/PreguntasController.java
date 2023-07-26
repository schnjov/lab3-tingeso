package cl.usach.preguntasservice.controllers;

import cl.usach.preguntasservice.entities.PreguntasEntity;
import cl.usach.preguntasservice.services.PreguntasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin({"http://localhost:3000", "http://localhost:3001","http://34.176.65.111:3000"})
@RestController
@RequestMapping("/preguntas")
public class PreguntasController {
    @Autowired
    PreguntasService preguntasService;
    @GetMapping
    public ResponseEntity<List<PreguntasEntity>> getAllPreguntas() {
        List<PreguntasEntity> preguntas = preguntasService.getAllPreguntas();
        if(preguntas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/{dificultad}")
    public ResponseEntity<List<PreguntasEntity>> getPreguntasByDificultad(@PathVariable String dificultad) {
        List<PreguntasEntity> preguntas = preguntasService.getPreguntasByDificultad(dificultad);
        if(preguntas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(preguntas);
    }

    @PostMapping
    public ResponseEntity<PreguntasEntity> guardarPregunta(@RequestBody PreguntasEntity pregunta) {
        preguntasService.guardarPregunta(pregunta);
        return ResponseEntity.ok(pregunta);
    }
}
