package com.fjulca.api.empleado.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				
				registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("GET","POST","HEAD","PUT","DELETE","OPTIONS","TRACE","PATCH")
				.allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization");
			}
		};
	}
}
