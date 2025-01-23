package com.tutorial.msdockerpersonas.controllers;


import com.tutorial.msdockerpersonas.controllers.exceptions.DatabaseEmptyException;
import com.tutorial.msdockerpersonas.controllers.exceptions.ResourceNotFoundException;
import com.tutorial.msdockerpersonas.services.personaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("v1/api/persona")
public class personaController {

    @Autowired
    private personaService personaService;


    @GetMapping("/all")
    public ResponseEntity<?> getAllPersonas() {
        if(personaService.findAll().isEmpty()){
            throw new DatabaseEmptyException("No hay registros en la base de datos");
        }
        return ResponseEntity.ok(personaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonaByID (@PathVariable(value = "id") Long id) {
            if(!personaService.isPresent(id)){
                throw new ResourceNotFoundException("No se encontro registro");
            }
        return ResponseEntity.ok(personaService.findById(id));
    }


}
