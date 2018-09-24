package com.alejo.ejercicio.call.chain;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.alejo.ejercicio.call.chain.impl.AbstractEmpleadoChain;
import com.alejo.ejercicio.call.model.Director;
import com.alejo.ejercicio.call.model.Empleado;
import com.alejo.ejercicio.call.model.Operador;
import com.alejo.ejercicio.call.model.Supervisor;
import com.alejo.ejercicio.call.repository.EmpleadoRepository;
import com.alejo.ejercicio.call.service.EmpleadoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpleadoChainTest {
	
	@SpyBean
    private AbstractEmpleadoChain<Operador> operadorChain;
    
	@SpyBean
    private AbstractEmpleadoChain<Supervisor> supervisorChain;
    
	@SpyBean
    private AbstractEmpleadoChain<Director> directorChain;
    
    @MockBean
    private EmpleadoRepository<Operador> operadorRepository;
    
    @MockBean
    private EmpleadoRepository<Supervisor> supervisorRepository;
    
    @MockBean
    private EmpleadoRepository<Director> directorRepository;
    
    @Autowired
    private EmpleadoService empleadoService;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void empleadosLibresTest() {

        Operador operador = new Operador("Operador", "");
        when(operadorRepository.findFirstByLibreIsTrue()).thenReturn(operador);
        when(operadorRepository.save(operador)).thenReturn(operador);

        Empleado response = empleadoService.obtenerEmpleadoLibre();

        assertTrue(response instanceof Operador);
        assertTrue("Operador".equals(response.getNombre()));
    }

    @Test
    public void operadoresOcupadosTest() {

        Supervisor supervisor = new Supervisor("Supervisor", "");
        when(operadorRepository.findFirstByLibreIsTrue()).thenReturn(null);
        when(supervisorRepository.findFirstByLibreIsTrue()).thenReturn(supervisor);
        when(supervisorRepository.save(supervisor)).thenReturn(supervisor);

        Empleado response = empleadoService.obtenerEmpleadoLibre();

        assertTrue(response instanceof Supervisor);
        assertTrue("Supervisor".equals(response.getNombre()));
    }
    
    @Test
    public void operadoresSupervisoresOcupadosTest() {
    	
    	Director director = new Director("Director", "");
    	when(operadorRepository.findFirstByLibreIsTrue()).thenReturn(null);
        when(supervisorRepository.findFirstByLibreIsTrue()).thenReturn(null);
        when(directorRepository.findFirstByLibreIsTrue()).thenReturn(director);
        when(directorRepository.save(director)).thenReturn(director);

        Empleado response = empleadoService.obtenerEmpleadoLibre();

        assertTrue(response instanceof Director);
        assertTrue("Director".equals(response.getNombre()));
    }
    
    @Test
    public void todosOcupadosTest() {
    	
    	when(operadorRepository.findFirstByLibreIsTrue()).thenReturn(null);
        when(supervisorRepository.findFirstByLibreIsTrue()).thenReturn(null);
        when(directorRepository.findFirstByLibreIsTrue()).thenReturn(null);
        
        Empleado response = empleadoService.obtenerEmpleadoLibre();

        assertTrue(response == null);
    	
    }
}
