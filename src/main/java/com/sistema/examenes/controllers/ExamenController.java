/*package com.sistema.examenes.controllers;

import com.sistema.examenes.entity.Examen;
import com.sistema.examenes.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/examen")
@CrossOrigin("*")
public class ExamenController {

    @Autowired
    private ExamenService examenService;


    @PostMapping("/")
    public ResponseEntity<Examen> guardarExamen(@RequestBody Examen examen){
        return ResponseEntity.ok(examenService.agregarExamen(examen));
    }


    @PutMapping("/")
    public ResponseEntity<Examen> actualizarExamen(@RequestBody Examen examen){
        return ResponseEntity.ok(examenService.actualizarExamen(examen));
    }


    @GetMapping("/")
    public ResponseEntity<?> listarExamens(){
        return ResponseEntity.ok(examenService.obtenerExamenes());
    }


    @GetMapping("/{examenId}")
    public Examen listarExamenPorId(@PathVariable("examenId") Long examenId){
        return examenService.obtenerExamen(examenId);
    }


    @DeleteMapping("/{examenId}")
    public void eliminarExamen(@PathVariable("examenId") Long examenId){
        examenService.eliminarExamen(examenId);
    }

}
*/