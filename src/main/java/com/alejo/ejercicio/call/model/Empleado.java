package com.alejo.ejercicio.call.model;

import org.springframework.data.annotation.Id;

public class Empleado {

	@Id
	private String id;
	private String nombre;
	private String apellido;
	private Boolean libre;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Boolean getLibre() {
		return libre;
	}
	public void setLibre(Boolean libre) {
		this.libre = libre;
	}
	
	
}
