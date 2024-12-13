package com.example.ProductoApi.controller;

import com.example.ProductoApi.model.*;
import com.example.ProductoApi.service.*;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    // Obtener todos los productos
    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    // crear un nuevo producto
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.crearProducto(producto)
                .orElseThrow(() -> new RuntimeException("Ocurrió un problema al crear el producto"));

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto actualizarProducto = productoService.actualizarProducto(id, producto)
                .orElseThrow(() -> new RuntimeException("Problemas al actualizar el producto"));

        return ResponseEntity.ok(actualizarProducto);
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}