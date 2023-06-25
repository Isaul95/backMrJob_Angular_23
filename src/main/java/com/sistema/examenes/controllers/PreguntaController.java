package com.sistema.examenes.controllers;

import com.sistema.examenes.entity.Examen;
import com.sistema.examenes.entity.Pregunta;
import com.sistema.examenes.service.ExamenService;
import com.sistema.examenes.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/pregunta")
@CrossOrigin("*")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @Autowired
    private ExamenService examenService;


    @PostMapping("/")
    public ResponseEntity<Pregunta> guardarPregunta(@RequestBody Pregunta pregunta){

        return  ResponseEntity.ok(preguntaService.agregarPregunta(pregunta));
    }


    @PutMapping("/")
    public ResponseEntity<Pregunta> actualizarPregunta(@RequestBody Pregunta pregunta){

        return ResponseEntity.ok(preguntaService.actualizarPregunta(pregunta));
    }


    @GetMapping("/examen/{examenId}")
    public ResponseEntity<?> listarPreguntasDelExamen(@PathVariable("examenId") Long examenId){

        Examen examen = examenService.obtenerExamen(examenId);
        Set<Pregunta> preguntas = examen.getPreguntas();

        List examenes = new ArrayList(preguntas);

        if(examenes.size() > Integer.parseInt(examen.getNumeroDePreguntas())){
            examenes = examenes.subList(0,Integer.parseInt(examen.getNumeroDePreguntas()+1));
        }
        // shuffle => barajar, chocolatear, alterar el orden de las preguntas
        Collections.shuffle(examenes);
        return ResponseEntity.ok(examenes);
    }


    @GetMapping("/{preguntaId}")
    public Pregunta listarPreguntaPorId(@PathVariable("preguntaId") Long preguntaId){

        return preguntaService.obtenerPregunta(preguntaId);
    }


    @DeleteMapping("/{preguntaId}")
    public void eliminarPregunta(@PathVariable("preguntaId") Long preguntaId){

        preguntaService.eliminarPregunta(preguntaId);
    }


    @GetMapping("/examen/todos/{examenId}")
    public ResponseEntity<?> listarPreguntaDelExamenComoAdmin(@PathVariable("examenId") Long examenId){
        Examen examen = new Examen();
        examen.setExamenId(examenId);
        Set<Pregunta> preguntas = preguntaService.obtenerPreguntasDelExamen(examen);

        return  ResponseEntity.ok(preguntas);
    }



}
