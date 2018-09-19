package com.alejo.ejercicio.call.service.impl;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alejo.ejercicio.call.model.Empleado;
import com.alejo.ejercicio.call.model.Llamada;
import com.alejo.ejercicio.call.repository.LlamadaRepository;
import com.alejo.ejercicio.call.service.EmpleadoService;
import com.alejo.ejercicio.call.service.LlamadaService;

@Component
public class LlamadaServiceImpl implements LlamadaService{
	
	private static Logger LOGGER = LoggerFactory.getLogger(LlamadaServiceImpl.class);
	
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
			manejarLlamada(llamadaRepository.save(llamada));
			finalizarLlamada(llamada);
		} else {
			return null;
		}
		return llamada;
	}

	private void finalizarLlamada(Llamada llamada) {
		empleadoService.liberarEmpleado(llamada.getEmpleado());
		llamadaRepository.save(llamada);
	}

	private void manejarLlamada(Llamada llamada) {
		try {
        	int duracion = 5 + (int)(Math.random()*(6));
            Thread.sleep(TimeUnit.SECONDS.toMillis(duracion));
        } catch (InterruptedException e) {
        	LOGGER.debug("Error con el thread de la llamada", e);
        }
	}

}
