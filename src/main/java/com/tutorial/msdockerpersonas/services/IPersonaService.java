package com.tutorial.msdockerpersonas.services;

import com.tutorial.msdockerpersonas.controllers.exceptions.DuplicatedDataException;
import com.tutorial.msdockerpersonas.controllers.exceptions.ResourceNotFoundException;
import com.tutorial.msdockerpersonas.entities.Persona;

public interface IPersonaService {

    Persona updatePersona (Persona persona, Long id) throws ResourceNotFoundException;

    boolean isDuplicated(Persona persona) throws DuplicatedDataException;
}
