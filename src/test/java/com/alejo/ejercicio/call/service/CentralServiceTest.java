package com.alejo.ejercicio.call.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.alejo.ejercicio.call.dispatcher.Dispatcher;
import com.alejo.ejercicio.call.model.Llamada;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CentralServiceTest {
	
	@Autowired
	CentralService centralService;
	
	@MockBean
	Dispatcher dispatcher;
	
	@Autowired
	@Qualifier("executor")
	ExecutorService executorService;
	
	@Test
    public void test10() throws Exception{
		
		Llamada llamadaTerminada = new Llamada();
		Mockito.when(dispatcher.dispatchCall()).thenReturn(llamadaTerminada);
		List<Llamada> llamadas = new ArrayList<>();
		for(int i = 0; i<=9; i++) {
			llamadas.add(centralService.recibirLlamada());
		}
		
		assertEquals(llamadas.size(), 10);

    }

}
