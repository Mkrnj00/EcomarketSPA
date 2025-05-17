package com.ecomarketspa_vm.cl.ecomarket.service;

import com.ecomarketspa_vm.cl.ecomarket.model.Producto;
import com.ecomarketspa_vm.cl.ecomarket.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id).get();
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizar(Long id, Producto nuevoProducto) {
        Producto existente = productoRepository.findById(id).get();
        if (existente != null) {
            existente.setNombre(nuevoProducto.getNombre());
            existente.setPrecio(nuevoProducto.getPrecio());
            return productoRepository.save(existente);
        }
        return null;
    }

    public boolean eliminar(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}