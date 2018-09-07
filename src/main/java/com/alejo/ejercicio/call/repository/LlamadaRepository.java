package com.alejo.ejercicio.call.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alejo.ejercicio.call.model.Llamada;

public interface LlamadaRepository extends MongoRepository<Llamada, String>{
	
}
