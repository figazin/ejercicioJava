package com.alejo.ejercicio.call.service;

import com.alejo.ejercicio.call.model.Empleado;

public interface EmpleadoService {
	
	Empleado obtenerEmpleadoLibre();

	void liberarEmpleado(Empleado empleado);

}
