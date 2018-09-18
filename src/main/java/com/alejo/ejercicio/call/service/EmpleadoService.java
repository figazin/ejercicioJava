package com.alejo.ejercicio.call.service;

import java.util.List;

import com.alejo.ejercicio.call.model.Empleado;
import com.alejo.ejercicio.call.model.Operador;

public interface EmpleadoService {
	
	Empleado obtenerEmpleadoLibre();

	void liberarEmpleado(Empleado empleado);

	List<Operador> crearEmpleados();
	
}
