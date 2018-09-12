package com.alejo.ejercicio.call.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alejo.ejercicio.call.model.Llamada;
import com.alejo.ejercicio.call.service.CentralService;

@RestController
@RequestMapping("/llamada")
public class LlamadasController {
	
	@Autowired
	CentralService centralService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Llamada iniciarLlamada() {
		return centralService.recibirLlamada();
	}

}
