package com.tutorial.msdockerpersonas.controllers;


import com.tutorial.msdockerpersonas.controllers.exceptions.GlobalExceptionsHandler;
import com.tutorial.msdockerpersonas.entities.Persona;
import com.tutorial.msdockerpersonas.services.personaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/persona")
public class personaController {

    @Autowired
    private personaService personaService;


    @GetMapping()
    public ResponseEntity<List<Persona>> getAllPersonas() throws Exception {
        return ResponseEntity.ok(personaService.findAll());
    }

    @GetMapping("/{id}")
    @ExceptionHandler()
    public ResponseEntity<Persona> getPersonaByID (@PathVariable(value = "id") Long id) throws Exception {
        return ResponseEntity.ok(this.personaService.findById(id));
    }
}
