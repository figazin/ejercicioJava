package com.alejo.ejercicio.call.chain.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.alejo.ejercicio.call.model.Empleado;
import com.alejo.ejercicio.call.repository.EmpleadoRepository;

public abstract class AbstractEmpleadoChain <E extends Empleado>{
	
	@Autowired
	private EmpleadoRepository<E> empleadoRepository;
	
	private AbstractEmpleadoChain nextChain;
	
	public void setNextChain(AbstractEmpleadoChain nextChain) {
		this.nextChain = nextChain;
	}
	
	public AbstractEmpleadoChain getNextChain(AbstractEmpleadoChain nextChain) {
		return nextChain;
	}
	
	public E obtenerEmpleado() {
		E empleado = empleadoRepository.findFirstByLibreIsTrue();
		if(empleado == null) {
			empleado = (E) nextChain.obtenerEmpleado();
		}
		empleado.setLibre(false);
		return empleadoRepository.save(empleado);
	}

	public void guardarEmpleado(Empleado empleado) {
		empleadoRepository.save((E) empleado);
	}

}
