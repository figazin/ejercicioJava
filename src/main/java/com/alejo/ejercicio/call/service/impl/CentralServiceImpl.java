package com.alejo.ejercicio.call.service.impl;

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
import com.alejo.ejercicio.call.service.CentralService;

@Component
public class CentralServiceImpl implements CentralService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CentralServiceImpl.class);

	@Autowired
	Dispatcher dispatcher;
	
	@Autowired
	@Qualifier("executor")
	ExecutorService executorService;
	
	@Override
	public Llamada recibirLlamada() {
		LOGGER.debug("Despacho la llamada");
		Future<Llamada> llamadaFuture = executorService.submit(() -> {
			return dispatcher.dispatchCall();
		});
		Llamada llamada = null;
		LOGGER.debug("Llamada terminada");
		try {
			llamada = llamadaFuture.get();
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.debug("Error al obtener la llamada", e);
		}
		return llamada;
	}

}
