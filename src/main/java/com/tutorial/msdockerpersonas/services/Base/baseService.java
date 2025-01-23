package com.tutorial.msdockerpersonas.services.Base;

import com.tutorial.msdockerpersonas.controllers.exceptions.DatabaseEmptyException;
import com.tutorial.msdockerpersonas.controllers.exceptions.ResourceNotFoundException;
import com.tutorial.msdockerpersonas.entities.base.BaseEntity;
import com.tutorial.msdockerpersonas.repositories.base.baseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Slf4j
public class baseService <E extends BaseEntity, ID extends Serializable> implements IBaseService<E, ID> {

    protected baseRepository<E, ID> BaseRepository;

    public baseService(baseRepository<E, ID> BaseRepository) {
        this.BaseRepository = BaseRepository;
    }


    @Override
    @Transactional
    public List<E> findAll() throws DatabaseEmptyException {
        List<E> entities = BaseRepository.findAll();
        if (entities.isEmpty()) {
            throw new DatabaseEmptyException("No hay registros en la base de datos");
        }
        return entities;
    }

    @Override
    @Transactional
    public Page<E> findAllPaged(Pageable pageable) throws Exception {
        try {
            return BaseRepository.findAll(pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional
    public E findById(ID id) throws ResourceNotFoundException {
        Optional<E> entityOptional = BaseRepository.findById(id);
        return entityOptional.orElseThrow(() -> new ResourceNotFoundException("No se encontro registro"));
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
            entity = BaseRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            Optional<E> entityOptional = BaseRepository.findById(id);
            E persona = entityOptional.get();
            persona = BaseRepository.save(entity);
            return persona;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            if (BaseRepository.existsById(id)){
                BaseRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public boolean isPresent(ID id){
        Optional<E> entityOptional = BaseRepository.findById(id);
        return entityOptional.isPresent();
    }

}
