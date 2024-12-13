package com.example.ProductoApi.service;

import com.example.ProductoApi.model.*;

import java.util.List;
import java.util.Optional;

//Interfaz que define los servicios
public interface ProductoService {

    // Metodo para traer la lista de todos los productos
    List<Producto> obtenerProductos();

    // Metodo para traer un producto por su id
    Optional<Producto> obtenerPorId(Long id);

    // Metodo para crear un producto
    Optional<Producto> crearProducto(Producto producto);

    // Metodo para actualizar un producto
    Optional<Producto> actualizarProducto(Long id, Producto producto);

    // Metodo para eliminar un producto por su id
    void eliminarProducto(Long id);

}
