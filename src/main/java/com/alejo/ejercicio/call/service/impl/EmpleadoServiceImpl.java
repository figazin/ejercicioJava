package com.alejo.ejercicio.call.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alejo.ejercicio.call.chain.impl.AbstractEmpleadoChain;
import com.alejo.ejercicio.call.model.Director;
import com.alejo.ejercicio.call.model.Empleado;
import com.alejo.ejercicio.call.model.Operador;
import com.alejo.ejercicio.call.model.Supervisor;
import com.alejo.ejercicio.call.repository.EmpleadoRepository;
import com.alejo.ejercicio.call.service.EmpleadoService;

@Component
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoRepository<Operador> operadorRespository;
	
	@Autowired
    private AbstractEmpleadoChain<Operador> operadorChain;
    @Autowired
    private AbstractEmpleadoChain<Supervisor> supervisorChain;
    @Autowired
    private AbstractEmpleadoChain<Director> directorChain;
	
    @PostConstruct
    public void postConstruct() {
    	operadorChain.setNextChain(supervisorChain);
    	supervisorChain.setNextChain(directorChain);
    }
    
	@Override
	public Empleado obtenerEmpleadoLibre() {
		Empleado empleadoLibre = operadorChain.obtenerEmpleado();
		return empleadoLibre;
	}

	@Override
	public void liberarEmpleado(Empleado empleado) {
		empleado.setLibre(true);
		operadorChain.guardarEmpleado(empleado);
	}

	@Override
	public List<Operador> crearEmpleados() {
		Operador operador = new Operador("Alejo", "Montana");
		List<Operador> lista = new ArrayList<Operador>();
		lista.add(operador);
		lista.add(operador);
		lista.add(operador);
		lista.add(operador);
		return operadorRespository.saveAll(lista);
	}

}
