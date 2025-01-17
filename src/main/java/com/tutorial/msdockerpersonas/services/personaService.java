package com.tutorial.msdockerpersonas.services;


import com.tutorial.msdockerpersonas.entities.Persona;
import com.tutorial.msdockerpersonas.repositories.base.baseRepository;
import com.tutorial.msdockerpersonas.services.Base.baseService;
import org.springframework.stereotype.Service;

@Service
public class personaService extends baseService<Persona, Long> implements IPersonaService {

    public personaService(baseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }
}
