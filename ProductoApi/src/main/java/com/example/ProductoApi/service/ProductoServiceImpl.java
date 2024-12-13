package com.example.ProductoApi.service;

import com.example.ProductoApi.model.*;
import com.example.ProductoApi.repository.*;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Optional<Producto> crearProducto(Producto producto) {
        Producto productoParaGuardar = Producto
                .builder()
                .reference(UUID.randomUUID().toString())
                .nombre(producto.getNombre())
                .precio(producto.getPrecio())
                .isActive(true)
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();
        return Optional.of(productoRepository.save(productoParaGuardar));
    }

    @Override
    public Optional<Producto> actualizarProducto(Long id, Producto producto) {
        Optional<Producto> productoViejo = productoRepository.findById(id);
        if (productoViejo.isPresent()) {
            Producto productoParaActualizar = productoViejo.get();
            productoParaActualizar.setNombre(producto.getNombre());
            productoParaActualizar.setPrecio(producto.getPrecio());
            productoParaActualizar.setUpdatedAt(ZonedDateTime.now());
            return Optional.of(productoRepository.save(productoParaActualizar));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

}