package com.alejo.ejercicio.call.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "empleado")
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
	
	public Empleado() {
		
	}
	
	public Empleado(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.libre = true;
	}
	
	
}
