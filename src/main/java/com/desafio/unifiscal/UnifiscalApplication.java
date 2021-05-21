package com.desafio.unifiscal;

import java.util.Arrays; 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class UnifiscalApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnifiscalApplication.class, args);
	}
	  @Bean
	    public CorsFilter corsFilter() {
	    	
	    	CorsConfiguration config = new CorsConfiguration();
	    	config.setAllowCredentials(true);
	    	config.addAllowedHeader("*");
	    	config.addAllowedMethod("*");
	    	//config.setMaxAge(3600L);
	    	//para inserir mais origens
	    	config.setAllowedOrigins(Arrays.asList("http://localhost:8081", "*"));
	    	
	    	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    	source.registerCorsConfiguration("/**", config);
	    	
	    	return new CorsFilter(source);
	    	
	    }

}
