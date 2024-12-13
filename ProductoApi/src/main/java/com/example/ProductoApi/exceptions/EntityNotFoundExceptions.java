package com.example.ProductoApi.exceptions;

//Excepción específica (no se modifica)
public class EntityNotFoundExceptions extends RuntimeException {
    public EntityNotFoundExceptions(String message) {
        super(message);

    }
}
