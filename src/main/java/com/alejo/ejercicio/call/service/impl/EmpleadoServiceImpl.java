package com.alejo.ejercicio.call.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alejo.ejercicio.call.model.Empleado;
import com.alejo.ejercicio.call.repository.EmpleadoRepository;
import com.alejo.ejercicio.call.service.EmpleadoService;

@Component
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	EmpleadoRepository empleadoRepository;

	@Override
	public Empleado obtenerEmpleadoLibre() {
		return empleadoRepository.findFirstByLibre();
	}

}
