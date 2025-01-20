package com.tutorial.msdockerpersonas.controllers;


import com.tutorial.msdockerpersonas.controllers.exceptions.ResourceNotFoundException;
import com.tutorial.msdockerpersonas.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tutorial.msdockerpersonas.services.productoService;

import java.util.List;

@RestController
@RequestMapping("v1/api/productos")
public class productoController {

    @Autowired
    private productoService productoService;

    @GetMapping()
    public ResponseEntity<List<Producto>> getAllproductos () throws ResourceNotFoundException {
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Producto> getOneProducto (@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productoService.findById(id));
    }
}
