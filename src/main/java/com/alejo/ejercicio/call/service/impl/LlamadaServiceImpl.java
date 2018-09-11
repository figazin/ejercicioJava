package com.alejo.ejercicio.call.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alejo.ejercicio.call.model.Empleado;
import com.alejo.ejercicio.call.model.Llamada;
import com.alejo.ejercicio.call.repository.LlamadaRepository;
import com.alejo.ejercicio.call.service.EmpleadoService;
import com.alejo.ejercicio.call.service.LlamadaService;

@Component
public class LlamadaServiceImpl implements LlamadaService{
	
	@Autowired
	LlamadaRepository llamadaRepository;
	
	@Autowired
	EmpleadoService empleadoService;

	@Override
	public Llamada iniciarLlamada() {
		Llamada llamada = new Llamada();
		Empleado empleado = empleadoService.obtenerEmpleadoLibre();
		if(empleado != null) {
			llamada.setEmpleado(empleado);
			llamadaRepository.save(llamada);
		} 
		return llamada;
	}

}
