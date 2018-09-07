package com.alejo.ejercicio.call.config.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorConfig {
	
    private static final int MAX_CONCURRENT = 10;

    @Bean("executor")
    public ExecutorService customExecutorService(){
    	return Executors.newFixedThreadPool(MAX_CONCURRENT);
    }

}
