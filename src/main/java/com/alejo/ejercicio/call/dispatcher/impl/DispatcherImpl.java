package com.alejo.ejercicio.call.dispatcher.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.alejo.ejercicio.call.dispatcher.Dispatcher;
import com.alejo.ejercicio.call.model.Llamada;
import com.alejo.ejercicio.call.service.LlamadaService;

@Component
public class DispatcherImpl implements Dispatcher {

	private static Logger LOGGER = LoggerFactory.getLogger(DispatcherImpl.class);
	
	@Autowired
	@Qualifier("executor")
	ExecutorService executorService;

	@Autowired
	LlamadaService llamadaService;

	@Override
	public Llamada dispatchCall() {
		Future<Llamada> llamadaFuture = executorService.submit(() -> {
			return llamadaService.iniciarLlamada();
		});
		Llamada llamada = null;
		try {
			llamada = llamadaFuture.get();
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.debug("Error al obtener la llamada", e);
		}
		return llamada;
	}

}
