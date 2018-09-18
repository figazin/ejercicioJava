package com.alejo.ejercicio.call.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "empleado")
@TypeAlias("supervisor")
public class Supervisor extends Empleado {
	
	public Supervisor() {
		super();
	}
	
	public Supervisor(String nombre, String apellido) {
		super(nombre, apellido);
	}

}
