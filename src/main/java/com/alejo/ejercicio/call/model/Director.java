package com.alejo.ejercicio.call.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "empleado")
@TypeAlias("director")
public class Director extends Empleado {

	public Director() {
		super();
	}
	
	public Director(String nombre, String apellido) {
		super(nombre, apellido);
	}
}
