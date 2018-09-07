package com.alejo.ejercicio.call.dispatcher.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.alejo.ejercicio.call.dispatcher.Dispatcher;
import com.alejo.ejercicio.call.service.LlamadaService;

@Component
public class DispatcherImpl implements Dispatcher {
	
	@Autowired
    @Qualifier("executor")
	ExecutorService executorService;
	
	@Autowired
	LlamadaService llamadaService;

	@Override
	public void dispatchCall() {
		try {
			executorService.submit(() -> {
				llamadaService.iniciarLlamada();
			}).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}

}
