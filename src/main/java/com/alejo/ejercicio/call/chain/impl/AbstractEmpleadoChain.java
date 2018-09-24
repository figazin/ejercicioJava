package com.alejo.ejercicio.call.chain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	public Empleado obtenerEmpleado() {
		//Agregar LockModeType PessimisticLocking
		E empleado = empleadoRepository.findFirstByLibreIsTrue();
		if(empleado == null) {
			if(nextChain != null) {
				empleado = (E) nextChain.obtenerEmpleado();
			} else {
				empleado = null;
			}
		} else {
			empleado.setLibre(false);
			empleado = empleadoRepository.save(empleado);
		}
		return empleado;
	}

	public E guardarEmpleado(Empleado empleado) {
		return empleadoRepository.save((E) empleado);
	}
	
}
