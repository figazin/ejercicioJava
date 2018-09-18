package com.alejo.ejercicio.call.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "empleado")
@TypeAlias("operador")
public class Operador extends Empleado {
	
	public Operador() {
		super();
	}
	
	public Operador(String nombre, String apellido) {
		super(nombre, apellido);
	}

}
