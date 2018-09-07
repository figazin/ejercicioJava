package com.alejo.ejercicio.call.model;

import org.springframework.data.annotation.Id;

public class Llamada {
	
	@Id
	private String id;
	private Empleado empleado;
	
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	

}
