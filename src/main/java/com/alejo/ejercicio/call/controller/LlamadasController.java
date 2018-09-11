package com.alejo.ejercicio.call.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alejo.ejercicio.call.dispatcher.Dispatcher;
import com.alejo.ejercicio.call.model.Llamada;

@RestController
@RequestMapping("/llamada")
public class LlamadasController {
	
	@Autowired
	Dispatcher dispatcher;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Llamada iniciarLlamada() {
		return dispatcher.dispatchCall();
	}

}
