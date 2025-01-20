package com.tutorial.msdockerpersonas.controllers;


import com.tutorial.msdockerpersonas.controllers.exceptions.DatabaseEmptyException;
import com.tutorial.msdockerpersonas.controllers.exceptions.GlobalExceptionsHandler;
import com.tutorial.msdockerpersonas.controllers.exceptions.ResourceNotFoundException;
import com.tutorial.msdockerpersonas.entities.Persona;
import com.tutorial.msdockerpersonas.services.personaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("v1/api/persona")
public class personaController {

    @Autowired
    private personaService personaService;


    @GetMapping("/all")
    public ResponseEntity<?> getAllPersonas() throws DatabaseEmptyException {
        return ResponseEntity.ok(personaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonaByID (@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
            if(!personaService.isPresent(id)){
                log.error("Entre al if : ResourceNotFoundException");
                throw new ResourceNotFoundException("No se encontro registro");
            }
        return ResponseEntity.ok(personaService.findById(id));
    }


}
