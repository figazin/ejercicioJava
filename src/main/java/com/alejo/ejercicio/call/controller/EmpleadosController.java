package com.alejo.ejercicio.call.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alejo.ejercicio.call.model.Operador;
import com.alejo.ejercicio.call.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadosController {
	
	@Autowired
	EmpleadoService empleadoService;
	
	@RequestMapping(value = "/crearEmpleados", method = RequestMethod.GET)
	public List<Operador> crearEmpleados() {
		return empleadoService.crearEmpleados();
	}
	
}
