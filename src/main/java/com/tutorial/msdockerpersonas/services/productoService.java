package com.tutorial.msdockerpersonas.services;

import com.tutorial.msdockerpersonas.entities.Producto;
import com.tutorial.msdockerpersonas.repositories.base.baseRepository;
import com.tutorial.msdockerpersonas.services.Base.baseService;
import org.springframework.stereotype.Service;


@Service
public class productoService extends baseService<Producto, Long> implements IProductoService {

    public productoService(baseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }
}
