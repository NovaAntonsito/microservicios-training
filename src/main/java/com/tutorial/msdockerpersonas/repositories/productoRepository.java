package com.tutorial.msdockerpersonas.repositories;

import com.tutorial.msdockerpersonas.entities.Producto;
import com.tutorial.msdockerpersonas.repositories.base.baseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productoRepository extends baseRepository<Producto, Long> {
}
