package com.ecomarketspa_vm.cl.ecomarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarketspa_vm.cl.ecomarket.model.Producto;
import com.ecomarketspa_vm.cl.ecomarket.service.ProductoService;

@RestController
@RequestMapping(path = "/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> productos = productoService.obtenerTodos();

        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build(); // alternativa 2 -> return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(productos); // alternativa 2 -> return new ResponseEntity<>(productos, HttpStatus.OK);
    }
}
