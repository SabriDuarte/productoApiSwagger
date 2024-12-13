package com.example.ProductoApi.repository;

import com.example.ProductoApi.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Consulta para encontrar todos los productos
    @Query("SELECT u FROM Producto u WHERE u.isActive = true")
    List<Producto> findAllActive();

    // consulta para encontrar un producto activo por ID
    @Query("SELECT u FROM Producto u WHERE u.id = :id AND u.isActive = true")
    Optional<Producto> findActiveById(@Param("id") long id);

    // Consulta para encontrar un producto activo por referencia
    @Query("SELECT u FROM Producto u WHERE u.reference = :reference AND u.isActive = true")
    Optional<Producto> findActiveByReference(@Param("reference") String reference);

}
