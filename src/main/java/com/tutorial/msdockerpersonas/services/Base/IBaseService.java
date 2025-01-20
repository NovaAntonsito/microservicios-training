package com.tutorial.msdockerpersonas.services.Base;

import com.tutorial.msdockerpersonas.entities.base.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IBaseService  <E extends BaseEntity, ID extends Serializable>{
    public List<E> findAll() throws Exception;

    //Get all Paged
    public Page<E> findAllPaged(Pageable pageable) throws Exception;
    //Get One
    public E findById(ID id) throws Exception;
    //Post
    public E save(E entity) throws Exception;
    //Put
    public E update(ID id, E entity) throws Exception;
    //Delete
    public boolean delete(ID id) throws Exception;

    public boolean isPresent(ID id) throws Exception;

}
