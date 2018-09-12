package com.alejo.ejercicio.call.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.alejo.ejercicio.call.model.Empleado;

@NoRepositoryBean
public interface EmpleadoRepository<E extends Empleado> extends MongoRepository<E, String> {

    public E findFirstByLibreIsTrue();
    
}